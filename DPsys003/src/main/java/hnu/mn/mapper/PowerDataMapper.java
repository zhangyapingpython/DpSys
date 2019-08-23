package hnu.mn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import hnu.mn.pojo.PowerData;

public interface PowerDataMapper {
	//根据可执行权限数据ID 查找具体数据权限
	List<PowerData> selByPowerDataID(@Param("powerDataID") int powerDataID);
}
