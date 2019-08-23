package hnu.mn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import hnu.mn.pojo.PowerData;
import hnu.mn.pojo.PowerExe;

public interface PowerExeMapper {
	//根据可执行权限数据 查找具体执行权限
	List<PowerExe> selByPowerExeID(@Param("powerExeID") int powerExeID);
}
