package tk.lexno.blog.dao;

import java.util.List;

import tk.lexno.blog.entity.SysView;
import tk.lexno.blog.entity.SysViewExample;

public interface SysViewMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysView record);

    int insertSelective(SysView record);

    List<SysView> selectByExample(SysViewExample example);

    SysView selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysView record);

    int updateByPrimaryKey(SysView record);
}