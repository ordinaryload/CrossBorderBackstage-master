package sugar.mapper;

import org.apache.ibatis.annotations.Param;
import sugar.bean.Settings;
import sugar.bean.SettingsExample;

import java.util.List;

public interface SettingsMapper {
    long countByExample(SettingsExample example);

    int deleteByExample(SettingsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Settings record);

    int insertSelective(Settings record);

    List<Settings> selectByExample(SettingsExample example);

    Settings selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Settings record, @Param("example") SettingsExample example);

    int updateByExample(@Param("record") Settings record, @Param("example") SettingsExample example);

    int updateByPrimaryKeySelective(Settings record);

    int updateByPrimaryKey(Settings record);
}