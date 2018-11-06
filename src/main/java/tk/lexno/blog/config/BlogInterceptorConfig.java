package tk.lexno.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import tk.lexno.blog.interceptor.ForeInterceptor;

@Configuration
public class BlogInterceptorConfig implements WebMvcConfigurer {

    @Bean
    public ForeInterceptor getForeInterceptor() {
        return new ForeInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getForeInterceptor()).addPathPatterns("/**").excludePathPatterns("/toLogin", "/admin/**", "/js/**", "/css/**", "/img/**");
    }
}
