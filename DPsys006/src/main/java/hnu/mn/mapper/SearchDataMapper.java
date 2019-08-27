package hnu.mn.mapper;

import hnu.mn.pojo.DataInfo;

public interface SearchDataMapper {
	//根据前台传递的dataName，dataCol，start，end进行数据库查询
	String selCountByFormSearch(DataInfo dataInfo);

	String selAvgByFormSearch(DataInfo dataInfo);
	
	//可能查询的字段范围不对，所有需要查的最大值和最小值
	String selMaxByFormSearch(DataInfo dataInfo);
	
	String selMinByFormSearch(DataInfo dataInfo);
	
	
	
	
}
