package tk.lexno.blog.service.impl;

import org.springframework.stereotype.Service;
import tk.lexno.blog.dao.SysLogMapper;
import tk.lexno.blog.dao.SysViewMapper;
import tk.lexno.blog.entity.SysLog;
import tk.lexno.blog.entity.SysView;
import tk.lexno.blog.service.SysService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysServiceImpl implements SysService {

    @Resource
    private SysLogMapper sysLogMapper;
    @Resource
    private SysViewMapper sysViewMapper;


    @Override
    public void addLog(SysLog sysLog) {
        sysLogMapper.insertSelective(sysLog);
    }

    @Override
    public void addView(SysView sysView) {
        sysViewMapper.insertSelective(sysView);
    }

    @Override
    public Long getLogCount() {
        return sysLogMapper.selectAllLogCount();
    }

    @Override
    public Long getViewCount() {
        return sysViewMapper.selectAllViewCount();
    }

    @Override
    public List<SysLog> listAllLog() {
        return sysLogMapper.selectAllLog();
    }

    @Override
    public List<SysView> listAllView() {
        return sysViewMapper.selectAllView();
    }
}
