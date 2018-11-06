package tk.lexno.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import tk.lexno.blog.config.BlogInterceptorConfig;
import tk.lexno.blog.config.ConfigBean;

@SpringBootApplication
@EnableConfigurationProperties({ConfigBean.class})
@MapperScan("tk.lexno.blog.dao")
public class BlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }
}
