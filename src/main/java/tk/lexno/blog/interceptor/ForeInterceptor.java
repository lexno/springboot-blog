package tk.lexno.blog.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import tk.lexno.blog.entity.SysLog;
import tk.lexno.blog.entity.SysView;
import tk.lexno.blog.service.SysService;
import tk.lexno.blog.util.BrowserUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class ForeInterceptor implements HandlerInterceptor {

    @Resource
    private SysService sysService;

    private SysLog sysLog = new SysLog();
    private SysView sysView = new SysView();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                    @Nullable ModelAndView modelAndView) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        // 获取访问者的IP地址
        String ip = request.getRemoteAddr();

        // 获取访问地址
        String url = request.getRequestURL().toString();

        // 得到用户浏览器信息

        // 增加log
        sysLog.setIp(ip);
        sysLog.setOperateBy(BrowserUtils.getOsAndBrowserInfo(request));
        sysLog.setOperateUrl(url);
        sysLog.setRemark(method.getName());

        sysService.addLog(sysLog);
        // 增加访问量
        sysView.setIp(ip);
        sysService.addView(sysView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                         @Nullable Exception ex) throws Exception {
    }
}
