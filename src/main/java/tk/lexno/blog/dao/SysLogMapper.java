package tk.lexno.blog.dao;

import java.util.List;

import ch.qos.logback.classic.net.SyslogAppender;
import tk.lexno.blog.entity.SysLog;
import tk.lexno.blog.entity.SysLogExample;

public interface SysLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysLog record);

    int insertSelective(SysLog record);

    List<SysLog> selectByExample(SysLogExample example);

    SysLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysLog record);

    int updateByPrimaryKey(SysLog record);

    List<SysLog> selectAllLog();

    Long selectAllLogCount();
}