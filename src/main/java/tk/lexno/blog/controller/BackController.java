package tk.lexno.blog.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.lexno.blog.entity.ArticleInfo;

@RestController
@RequestMapping("/admin")
@Api(tags="后台管理")
public class BackController {
    /**
     * 添加一篇文章
     * @param articleInfo
     * @return
     */
    @ApiOperation("添加一篇文章")
    @PostMapping("/add/article")
    public String addArticle(ArticleInfo articleInfo) {
        return null;
    }


}
