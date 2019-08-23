package hnu.mn.mapper;

import org.apache.ibatis.annotations.Param;

public interface EmpDataMapper {
	//暂时不要
	double selByUserPosted(@Param("dataName") String dataName,@Param("colName") String colName,
			@Param("start") int start,@Param("end") int end);
	
	double selAvgByUserPosted(@Param("dataName") String dataName,@Param("colName") String colName,
			@Param("start") int start,@Param("end") int end);
}
