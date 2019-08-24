package hnu.mn.controller;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import hnu.mn.pojo.DataInfo;
import hnu.mn.pojo.LoginUser;
import hnu.mn.pojo.MyError;
import hnu.mn.pojo.Permission;
import hnu.mn.pojo.User;
import hnu.mn.service.PermissionService;
import hnu.mn.service.SearchDataService;
import hnu.mn.service.UserService;
import hnu.mn.utils.String2IntUtil;

//控制器
@Controller
public class UserController {
	@Resource
	UserService userServiceImpl;

	@Resource
	PermissionService permissionServiceImpl;

	@Resource
	SearchDataService searchDataServiceImpl;

	@RequestMapping("{page}")
	public String main(@PathVariable String page) {
		System.out.println("restful");
		return page;
	}

	@RequestMapping("login")
	public String login(String userAccount, String password, HttpSession session) {
		// 直接访问 80：login
		if (userAccount == null || password == null) {
			System.out.println("没有数据直接跳转登陆页面");
			return "redirect:/login.jsp";
		}
		// 将前端数据传递给user (userAccount,password)
		User getFormUser = new User();
		getFormUser.setUserAccount(userAccount);
		getFormUser.setPassword(password);

		User user = userServiceImpl.login(getFormUser);
		System.out.println(user);
		if (user != null) {
			// 说明有这个用户 接下来要存储信息好取
			session.setAttribute("user", user);
			System.out.println("存入的数据user " + user);
			// 这是转发
			return "main";
		} else {
			// 这是重定向
			System.out.println("重定向llogin");
			return "redirect:/login.jsp";
		}
	}

	// 查询时附带数据表名，数据段，查询范围
	@RequestMapping("search")
	public String login(HttpServletRequest req, HttpSession session) {
		String dataName = req.getParameter("dataName").trim();
		String dataCol = req.getParameter("dataCol").trim();
		// 输入的数据都要判断，如是否可以转成int,有BUG先默认都按照正常来走
		String startString = req.getParameter("start");
		String2IntUtil string2IntUtil = new String2IntUtil();
		boolean flag2 = string2IntUtil.Str2Int(startString);
		if (flag2 == false) {
			// 不可以转，应该重定向回原始数据，并且载入错误信息
			// 这是转发
			return "main";
		}
		int start = Integer.parseInt(startString);
		String endString = req.getParameter("end");
		if ((!string2IntUtil.Str2Int(endString))) {
			// 不可以转，应该重定向回原始数据
			// 这是转发
			return "main";
		}
		int end = Integer.parseInt(endString);

		// 获取到的信息只要有一个为空，重新定位
		if (dataCol == null || dataCol == "" || dataName == null || dataName == "" || req.getParameter("start") == ""
				|| req.getParameter("start") == null || req.getParameter("end") == ""
				|| req.getParameter("end") == null) {
			System.out.println("字段号不对，到时候要完成重定向");
			return "main";
		}

		// 取出登陆的session中的用户信息
		User user = (User) session.getAttribute("user");
		int userID = user.getUserID();
		int queryNum = -1;
		int queryTime = -1;

		// 首先判断用户输入的数据表和数据字段是否有权限
		List<Permission> permissions = user.getRole().getPermission();
		boolean flag = false;

		for (Permission permission : permissions) {
			if (permission.getDataName().equals(dataName) && (permission.getDataCol().indexOf(dataCol) != -1)) {
				flag = true;
				// 当数据名和字段验证完后将获取查询次数和查询时间
				if (flag) {
					queryNum = permission.getQueryNum();
					queryTime = permission.getQueryTime();
				}
			}
		}
		// flag为真，说明有权限
		if (flag) {
			System.out.println("此次查询有效");
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			String username = user.getUsername();

			LoginUser getFormLoginUser = new LoginUser();
			getFormLoginUser.setDataName(dataName);
			getFormLoginUser.setUserID(userID);
			LoginUser loginUser = permissionServiceImpl.selByLoginUser(getFormLoginUser);
			if (loginUser != null) {
				// 如果数据库里存在LoginUser，说明有访问记录
				// 那么只需要判断访问次数和访问时间是否在合理范围
				Timestamp firstTime = loginUser.getFirstTime();
				long queryTime2 = loginUser.getQueryTime();
				int queryNum2 = loginUser.getQueryNum();
				// 时间合理，次数OK
				if ((((timestamp.getTime() - firstTime.getTime()) / 1000) <= (queryTime2 * 60)) && queryNum2 > 0) {
					// 进行查询操作，需要的参数有， 数据库名，字段名，开始，结束
					DataInfo dataInfo = new DataInfo(dataName, dataCol, start, end);
					//没有查询出结果
					if (searchDataServiceImpl.searchDataCountService(dataInfo)==null||
							searchDataServiceImpl.serachDataAvgService(dataInfo)==null) {
						return "main";
					}
					double searchCount = Double.parseDouble(searchDataServiceImpl.searchDataCountService(dataInfo));
					double serachAvg = Double.parseDouble(searchDataServiceImpl.serachDataAvgService(dataInfo));
					// 数据存入Sesssion
					session.setAttribute("serachAvg", serachAvg);
					session.setAttribute("searchCount", searchCount);
					System.out.println("不是第一次进入查询的数据    " + "和  " + searchCount + "  平均值  " + serachAvg);
					// 查询操作完，查询次数减一，设置查询剩余次数
					queryNum2--;
					session.setAttribute("remainQueryNum", queryNum2);
					// 查询间隔,第一次查询和现在的查询时间 单位秒
					long timeF2E = (timestamp.getTime() - firstTime.getTime()) / 1000;
					long remainTime = queryTime2 * 60 - timeF2E;
					int remainSecond = (int) (remainTime % 60);
					int remainMin = (int) (remainTime / 60);
					session.setAttribute("remainMin", remainMin);
					session.setAttribute("remainSecond", remainSecond);
					session.setAttribute("dataName", dataName);
					loginUser.setQueryNum(queryNum2);
					permissionServiceImpl.updLoginUserQueryTime(loginUser);
					return "main2";
				} else {
					// 不合理
					System.out.println("查询次数超过或查询时间超过");
					// 不让继续查询此数据库
					return "NoTimeOrNum";
				}
			} else {
				// 下面的是根据前台的数据查询用户需要的东西，代码暂缺
				DataInfo dataInfo = new DataInfo(dataName, dataCol, start, end);
				//没有查询出结果
				if (searchDataServiceImpl.searchDataCountService(dataInfo)==null||
						searchDataServiceImpl.serachDataAvgService(dataInfo)==null) {
					return "main";
				}
				double searchCount = Double.parseDouble(searchDataServiceImpl.searchDataCountService(dataInfo));
				double serachAvg = Double.parseDouble(searchDataServiceImpl.serachDataAvgService(dataInfo));
				// 数据存入Sesssion
				session.setAttribute("serachAvg", serachAvg);
				session.setAttribute("searchCount", searchCount);
				// System.out.println("第一次进入查询的数据 " + "和 " + searchCount + " 平均值 " + serachAvg);
				// 如果数据库里没有LoginUser，说明这是第一次访问
				// 应该讲访问数据存入，且将访问次数减一
				// 因为这也是一次访问
				LoginUser loginUserNew = new LoginUser(userID, username, queryTime, timestamp, --queryNum, dataName);
				session.setAttribute("remainQueryNum", queryNum);
				// 查询间隔,第一次查询和现在的查询时间 单位秒
				session.setAttribute("remainMin", queryTime);
				session.setAttribute("remainSecond", "0");
				session.setAttribute("dataName", dataName);
//				System.out.println("写入数据库  " + loginUserNew.getUsername());
				permissionServiceImpl.insLoginUser(loginUserNew);
				return "main2";
			}

		} else {
			System.out.println("无权限");
			return "NoPermission";

		}

	}
}