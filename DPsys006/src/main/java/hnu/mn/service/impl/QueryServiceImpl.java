package hnu.mn.service.impl;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import hnu.mn.mapper.DEmpMapper;
import hnu.mn.pojo.User;
import hnu.mn.service.QueryService;

@Service
public class QueryServiceImpl implements QueryService {
	@Resource
	DEmpMapper dEmpMapper;

	@Override
	public Object selSQL(String sql,HttpSession session) {
		//根据SQL语句进行查询		
		User user = (User) session.getAttribute("user");
		System.out.println("进入了selSQL");
		if (sql.toLowerCase().indexOf("select") == -1) {
			return "查询错误";
		}
		if (sql.toLowerCase().indexOf("count") != -1) {

			return dEmpMapper.selectCount(sql);
		}
		if (sql.toLowerCase().indexOf("avg") != -1) {
			//截取dataCol
			String dataCol = sql.substring(sql.toLowerCase().indexOf("avg(")+4, sql.toLowerCase().indexOf(")"));
			System.out.println(" 截取dataCol  "+dataCol);
			//目前不行int index=
			//String dataName = sql.substring(sql.toLowerCase().indexOf("from ")+5, sql.toLowerCase().indexOf(" "));
			//System.out.println(" 截取dataCol"+dataName);
			//求最大值，用来算差分隐私
			double selectDataColMax = dEmpMapper.selectDataColMax(dataCol);
			//加噪
			
			
			return dEmpMapper.selectAvg(sql);
		}
		if (sql.toLowerCase().indexOf("max") != -1) {

			return dEmpMapper.selectMax(sql);
		}

		if (sql.toLowerCase().indexOf("min") != -1) {

			return dEmpMapper.selectMin(sql);
		}

		if (sql.toLowerCase().indexOf("sum") != -1) {

			return dEmpMapper.selectSum(sql);
		}

		return dEmpMapper.selectAll(sql);
	}

}
