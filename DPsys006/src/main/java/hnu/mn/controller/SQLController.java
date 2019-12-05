package hnu.mn.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hnu.mn.pojo.DataReturn;
import hnu.mn.service.AASqlService;
import hnu.mn.service.QueryService;

@Controller
public class SQLController {
	@Resource
	QueryService queryServiceimpl;
	
	
	//直接执行SQL
	@RequestMapping("sqlQuery")
	@ResponseBody
	public DataReturn sqlQuery(String sql,HttpSession session) {
			System.out.println("sql语句  "+sql);
			DataReturn dataReturn=new DataReturn();
			
			
			//System.out.println(queryServiceimpl.selSQL(sql));
			Object object=queryServiceimpl.selSQL(sql,session);
			System.out.println(object);
			dataReturn.setStatus(200);
			dataReturn.setInfo("查询成功");
			return dataReturn;
		}
	
	
	
}
