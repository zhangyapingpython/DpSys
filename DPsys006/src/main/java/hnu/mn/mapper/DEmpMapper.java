package hnu.mn.mapper;

import hnu.mn.pojo.DEmp;
import hnu.mn.pojo.DEmpExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DEmpMapper {
    int countByExample(DEmpExample example);

    int deleteByExample(DEmpExample example);

    int deleteByPrimaryKey(Integer empid);

    int insert(DEmp record);

    int insertSelective(DEmp record);

    List<DEmp> selectByExample(DEmpExample example);

    DEmp selectByPrimaryKey(Integer empid);
    
    //<!--根据SQL查询 -->
    List<DEmp> selectAll(@Param("sql")String sql);
    
    //<!--根据SQL查询 -->
    int selectCount(@Param("sql")String sql);
    
    //<!--根据SQL查询 -->
    double selectAvg(@Param("sql")String sql);
    
    //<!--根据SQL查询 -->
    double selectSum(@Param("sql")String sql);
    
    //<!--根据SQL查询 -->
    double selectMax(@Param("sql")String sql);
    
    //<!--根据SQL查询 -->
    double selectMin(@Param("sql")String sql);
    
  //<!--根据SQL dataCol查询最大值 -->
    double selectDataColMax(@Param("dataCol") String dataCol);
    

    
    int updateByExampleSelective(@Param("record") DEmp record, @Param("example") DEmpExample example);

    int updateByExample(@Param("record") DEmp record, @Param("example") DEmpExample example);

    int updateByPrimaryKeySelective(DEmp record);

    int updateByPrimaryKey(DEmp record);
}