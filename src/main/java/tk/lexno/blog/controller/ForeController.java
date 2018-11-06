package tk.lexno.blog.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import tk.lexno.blog.common.CommonResult;
import tk.lexno.blog.dto.ArticleDto;
import tk.lexno.blog.entity.ArticleInfo;
import tk.lexno.blog.entity.CategoryInfo;
import tk.lexno.blog.entity.Comment;
import tk.lexno.blog.service.ArticleService;
import tk.lexno.blog.service.CategoryService;
import tk.lexno.blog.service.CommentService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 前台访问
 */
@RestController
@RequestMapping("/api")
public class ForeController {

    @Resource
    private ArticleService articleService;
    @Resource
    private CategoryService categoryService;
    @Resource
    private CommentService commentService;

    @ApiOperation("获取所有文章")
    @GetMapping("article/list")
    public List<ArticleInfo> listAllArticleInfo() {
        return articleService.findAll();
    }

    @ApiOperation("获取某一个分类下的所有文章")
    @ApiImplicitParam(name = "id", value = "分类ID", required = true, dataType = "Long")
    @GetMapping("article/list/category/{id}")
    public List<ArticleInfo> listArticleInfoByCategory(Long id) {
        return articleService.findByCategoryId(id);
    }

    @ApiOperation("获取最新的几篇文章")
    @GetMapping("article/list/lastest")
    public List<ArticleInfo> listLastestArticle() {
        return articleService.listLastest();
    }

    @ApiOperation("通过文章ID获取文章信息")
    @GetMapping("article/{id}")
    public ArticleDto getArticleById(@PathVariable Long id) {
        ArticleDto articleDto = articleService.getOneById(id);
        return articleDto;
    }

    @ApiOperation("获取所有分类信息")
    @GetMapping("category/list")
    public List<CategoryInfo> listAllCategoryInfo() {
        return categoryService.findAllCategories();
    }

    @ApiOperation("获取某一篇文章的评论信息")
    @ApiImplicitParam(name = "id", value = "文章ID", required = true, dataType = "Long")
    @GetMapping("comment/article/{id}")
    public List<Comment> listMessageByArticleId(@PathVariable Long id) {
        return commentService.listByArticleId(id);
    }

    @ApiOperation("给文章中增加一条评论信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "categoryId", value = "文章ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "content", value = "评论信息", required = true, dataType = "String"),
            @ApiImplicitParam(name = "email", value = "Email地址，用于回复", required = false, dataType = "String"),
            @ApiImplicitParam(name = "name", value = "用户自定义的名称", required = true, dataType = "String")
    })
    @PostMapping("comment/article/{id}")
    public CommonResult addArticleComment(@PathVariable Long id, @RequestBody Comment comment, HttpServletRequest request) {
        String ip = request.getRemoteAddr();
        comment.setIp(ip);
        comment.setArticleId(id);
        commentService.addComment(comment);
        return CommonResult.ok();
    }
}
