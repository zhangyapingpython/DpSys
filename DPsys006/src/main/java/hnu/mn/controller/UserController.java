package hnu.mn.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import hnu.mn.pojo.DataInfo;
import hnu.mn.pojo.DataReturnToForm;
import hnu.mn.pojo.LoginUser;
import hnu.mn.pojo.Permission;
import hnu.mn.pojo.User;
import hnu.mn.service.PermissionService;
import hnu.mn.service.SearchDataService;
import hnu.mn.service.UserService;

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
	
	//登录
	@SuppressWarnings("unused")
	@RequestMapping("login")
	public String login(String userAccount, String password, HttpSession session) {
		// 直接访问 80：login
		if (userAccount == null || password == null) {
			//System.out.println("没有数据直接跳转登陆页面");
			return "redirect:/login.jsp";
		}
		// 将前端数据传递给getFormUser (userAccount,password)
		User getFormUser = new User();
		getFormUser.setUserAccount(userAccount);
		getFormUser.setPassword(password);
		//System.out.println("login来的  "+getFormUser);
		User user = userServiceImpl.login(getFormUser);
		if (user.getRole().getName()=="管理员") {
			return "manage";
		}
		
		if (user != null) {
			// 说明有这个用户 接下来要存储信息好取，登陆成功
			session.setAttribute("user", user);
			//System.out.println("存入的数据user " + user);// 这是转发
			return "main";
		} else {
			// 这是重定向
			
			return "redirect:/login.jsp";
		}
	}

	// 注册，只是一个跳转功能
	@RequestMapping("regist")
	public String regist(User user, HttpSession session) {
		// 直接访问 80：login
		System.out.println("进入regist");
		return "regist";
	}

	// 注册成功应该跳转回登陆页面，然后需要自己再重新输入账号密码
	@RequestMapping("regist2")
	public String regist2(User user,HttpServletResponse resp, HttpSession session) {
		userServiceImpl.insUser(user);
		System.out.println("进入regist2"+user);
		return "redirect:/login.jsp";
	}
	
	@RequestMapping("checkRegistUserAccount")
	@ResponseBody
	public DataReturnToForm checkRegistUserAccount(String userAccount, HttpSession session) {
		System.out.println("进入checkRegistUserAccount"+userAccount);
		boolean checkUserAccount = userServiceImpl.checkUserAccount(userAccount);
		System.out.println("进入regist2"+checkUserAccount);
		DataReturnToForm dataReturnToForm=new DataReturnToForm();
		if (checkUserAccount) {	
			dataReturnToForm.setInfo("该账户可以注册");		
			return dataReturnToForm;
		}
		dataReturnToForm.setInfo("该账户已被占用");
		return dataReturnToForm;
	}

	@RequestMapping("ajax")
	@ResponseBody
	public DataReturnToForm ajax(DataInfo dataInfo, HttpServletRequest req, HttpServletResponse resp, HttpSession session)
			throws IOException {	
		String dataName = dataInfo.getDataName();
		String dataCol = dataInfo.getDataCol();
		//int start = dataInfo.getStart();
		//int end = dataInfo.getEnd();
		// 取出登陆的session中的用户信息
		User user = (User) session.getAttribute("user");
		int userID = user.getUserID();
		int queryNum = -1;
		int queryTime = -1;

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
			//System.out.println("此次查询有效");
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
					//如果-1，说明异常了
					double searchCount=-1;
					double searchAvg = -1;
					try {
						searchCount = Double.parseDouble(searchDataServiceImpl.searchDataCountService(dataInfo));
						searchAvg = Double.parseDouble(searchDataServiceImpl.serachDataAvgService(dataInfo));
					} catch (Exception e) {
						//System.out.println("错误了");
						e.printStackTrace();
						
						String error="查询范围有错误";
						DataReturnToForm dataReturnToForm=new DataReturnToForm(error);
						ObjectMapper objectMapper=new ObjectMapper();	
						objectMapper.writeValueAsString(dataReturnToForm);
						return dataReturnToForm;
					
					}
					
					// 查询操作完，查询次数减一，设置查询剩余次数
					queryNum2--;
					// 查询间隔,第一次查询和现在的查询时间 单位秒
					long timeF2E = (timestamp.getTime() - firstTime.getTime()) / 1000;
					long remainTime = queryTime2 * 60 - timeF2E;
					//剩余时间和次数
					int remainSecond = (int) (remainTime % 60);
					int remainMin = (int) (remainTime / 60);			
					//此次查询时间减一
					loginUser.setQueryNum(queryNum2);
					permissionServiceImpl.updLoginUserQueryTime(loginUser);
					//将结果返回给前台
					DataReturnToForm dataReturnToForm=new DataReturnToForm(searchCount, searchAvg, queryNum2, remainMin, remainSecond, dataName);
					ObjectMapper objectMapper=new ObjectMapper();	
					objectMapper.writeValueAsString(dataReturnToForm);
					return dataReturnToForm;
				
				} else {
					// 不合理
					//也是返回给ajax界面，提示查询次数超过或查询时间超过
					String error="查询次数超过或查询时间超过";
					// 不让继续查询此数据库
					DataReturnToForm dataReturnToForm=new DataReturnToForm(error);
					ObjectMapper objectMapper=new ObjectMapper();	
					objectMapper.writeValueAsString(dataReturnToForm);
					return dataReturnToForm;
				}
			} else {
				//第一次查询此系统的查询结果
				double searchCount=-1;
				double searchAvg = -1;
				try {
					searchCount = Double.parseDouble(searchDataServiceImpl.searchDataCountService(dataInfo));
					searchAvg = Double.parseDouble(searchDataServiceImpl.serachDataAvgService(dataInfo));
				} catch (Exception e) {
					//System.out.println("错误了");
					e.printStackTrace();
					
					String error="查询范围有错误";
					DataReturnToForm dataReturnToForm=new DataReturnToForm(error);
					ObjectMapper objectMapper=new ObjectMapper();	
					objectMapper.writeValueAsString(dataReturnToForm);
					return dataReturnToForm;
				
				}
				// 如果数据库里没有LoginUser，说明这是第一次访问
				// 应该讲访问数据存入，且将访问次数减一
				// 因为这也是一次访问
				LoginUser loginUserNew = new LoginUser(userID, username, queryTime, timestamp, --queryNum, dataName);
				
				permissionServiceImpl.insLoginUser(loginUserNew);
				DataReturnToForm dataReturnToForm=new DataReturnToForm(searchCount, searchAvg, queryNum, queryTime, 0, dataName);
				ObjectMapper objectMapper=new ObjectMapper();	
				objectMapper.writeValueAsString(dataReturnToForm);
				return dataReturnToForm;
			}

		} else {
			String error="你没有权限访问此字段，请检查自己的权限";
			DataReturnToForm dataReturnToForm=new DataReturnToForm(error);
			//因为查询的不满足
			System.out.println("无权限");
			//return "NoPermission";
			ObjectMapper objectMapper=new ObjectMapper();	
			objectMapper.writeValueAsString(dataReturnToForm);
			return dataReturnToForm;
		}

	}
}