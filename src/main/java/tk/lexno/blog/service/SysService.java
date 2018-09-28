package tk.lexno.blog.service;

import tk.lexno.blog.entity.SysLog;
import tk.lexno.blog.entity.SysView;

import java.util.List;

public interface SysService {

    /**
     * 增加一条日志
     * @param sysLog 日志
     */
    void addLog(SysLog sysLog);

    /**
     * 增加一条访问量
     * @param sysView 访问量
     */
    void addView(SysView sysView);

    /**
     * 获得日志的总数量
     * @return 总数量
     */
    int getLogCount();

    /**
     * 获得总访问量
     * @return 总访问量
     */
    int getViewCount();

    /**
     * 返回所有日志
     * @return 日志列表
     */
    List<SysLog> listAllLog();

    /**
     * 返回所有访问信息
     * @return 访问信息列表
     */
    List<SysView> listAllView();
}
