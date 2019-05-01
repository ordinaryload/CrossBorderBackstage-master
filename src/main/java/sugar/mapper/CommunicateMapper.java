package sugar.mapper;

import org.apache.ibatis.annotations.Param;
import sugar.bean.Communicate;
import sugar.bean.CommunicateExample;

import java.util.List;

public interface CommunicateMapper {
    long countByExample(CommunicateExample example);

    int deleteByExample(CommunicateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Communicate record);

    int insertSelective(Communicate record);

    List<Communicate> selectByExample(CommunicateExample example);

    Communicate selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Communicate record, @Param("example") CommunicateExample example);

    int updateByExample(@Param("record") Communicate record, @Param("example") CommunicateExample example);

    int updateByPrimaryKeySelective(Communicate record);

    int updateByPrimaryKey(Communicate record);
}