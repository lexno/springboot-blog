package tk.lexno.blog.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import tk.lexno.blog.common.CommonResult;
import tk.lexno.blog.config.ConfigBean;
import tk.lexno.blog.dto.ArticleDto;
import tk.lexno.blog.entity.*;
import tk.lexno.blog.service.ArticleService;
import tk.lexno.blog.service.CategoryService;
import tk.lexno.blog.service.CommentService;
import tk.lexno.blog.service.SysService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 后台管理
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private ArticleService articleService;
    @Resource
    private CategoryService categoryService;
    @Resource
    private CommentService commentService;
    @Resource
    private SysService sysService;
    @Resource
    private ConfigBean configBean;


    @PostMapping("/login")
    public void login(User user, HttpServletRequest request, HttpServletResponse response) throws Exception {
        if( configBean.getUsername().equals(user.getUsername())&& configBean.getPassword().equals(user.getPassword())) {
            request.getSession().setAttribute("user", user);
            response.sendRedirect(request.getContextPath() + "/admin/index.html");
        } else {
            response.sendRedirect(request.getContextPath() + "/toLogin");
        }
    }

    @ApiOperation("添加一篇文章")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "categoryId", value = "文章分类id", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "title", value = "文章标题", required = true, dataType = "String"),
            @ApiImplicitParam(name = "content", value = "文章内容", required = true, dataType = "String"),
            @ApiImplicitParam(name = "pictureUrl", value = "题图url", required = true, dataType = "String"),
            @ApiImplicitParam(name = "summary", value = "文章简介", required = true, dataType = "String"),
            @ApiImplicitParam(name = "isTop", value = "文章是否置顶", required = true, dataType = "Boolean")
    })
    @PostMapping("/article")
    public CommonResult addArticle(@RequestBody ArticleDto articleDto) {
        articleService.addArticle(articleDto);
        return CommonResult.ok();
    }

    @ApiOperation("删除一篇文章")
    @ApiImplicitParam(name = "id", value = "文章id", required = true, dataType = "Long")
    @DeleteMapping("/article/{id}")
    public CommonResult deleteArticle(@PathVariable Long id) {
        articleService.deleteArticleById(id);
        return CommonResult.ok();
    }

    @ApiOperation("修改一篇文章")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "categoryId", value = "文章分类id", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "title", value = "文章标题", required = true, dataType = "String"),
            @ApiImplicitParam(name = "content", value = "文章内容", required = true, dataType = "String"),
            @ApiImplicitParam(name = "pictureUrl", value = "题图url", required = true, dataType = "String"),
            @ApiImplicitParam(name = "summary", value = "文章简介", required = true, dataType = "String"),
            @ApiImplicitParam(name = "isTop", value = "文章是否置顶", required = true, dataType = "Boolean")
    })
    @PutMapping("/article/{id}")
    public CommonResult updateArticle(@PathVariable Long id, @RequestBody ArticleDto articleDto) {
        articleDto.setId(id);
        articleService.updateArticle(articleDto);
        return CommonResult.ok();
    }

    @ApiOperation("修改文章分类信息")
    @ApiImplicitParam(name = "categoryId", value = "文章分类id", required = true, dataType = "Long")
    @PutMapping("/article/category/{articleId}")
    public CommonResult updateArticleCategory(@PathVariable Long articleId, @RequestBody Long categoryId) {
        articleService.updateArticleCategory(articleId, categoryId);
        return CommonResult.ok();
    }

    @ApiOperation("获取文章信息")
    @ApiImplicitParam(name = "id", value = "文章id", required = true, dataType = "Long")
    @GetMapping("/article/{id}")
    public ArticleDto getArticle(@PathVariable Long id) {
        return articleService.getOneById(id);
    }

    @ApiOperation("新增文章分类信息")
    @ApiImplicitParam(name = "name", value = "分类名称", required = true, dataType = "String")
    @PostMapping("/category")
    public CommonResult addCategory(@RequestBody CategoryInfo categoryInfo) {
        categoryService.addCategory(categoryInfo);
        return CommonResult.ok();
    }

    @ApiOperation("修改文章分类信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "分类id", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "name", value = "分类名称", required = true, dataType = "String")
    })
    @PutMapping("/category/{id}")
    public CommonResult updateCategory(@PathVariable Long id, @RequestBody CategoryInfo categoryInfo) {
        categoryInfo.setId(id);
        categoryService.updateCategory(categoryInfo);
        return CommonResult.ok();
    }

    @ApiOperation("删除文章分类信息")
    @ApiImplicitParam(name = "id", value = "分类id", required = true, dataType = "Long")
    @DeleteMapping("/category/{id}")
    public CommonResult deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategoryById(id);
        return CommonResult.ok();
    }

    @ApiOperation("获取文章分类信息")
    @ApiImplicitParam(name = "id", value = "分类id", required = true, dataType = "Long")
    @GetMapping("/category/{id}")
    public CategoryInfo getCategory(@PathVariable Long id) {
        return categoryService.getOneById(id);
    }


    @ApiOperation("根据评论id删除评论")
    @ApiImplicitParam(name = "id", value = "评论id", required = true, dataType = "Long")
    @DeleteMapping("/comment/{id}")
    public CommonResult deleteComment(@PathVariable Long id) {
        commentService.deleteCommentById(id);
        return CommonResult.ok();
    }

    @ApiOperation("根据文章id删除评论")
    @ApiImplicitParam(name = "articleId", value = "文章id", required = true, dataType = "Long")
    @DeleteMapping("/comment/article/{articleId}")
    public CommonResult deleteCommentByArticleId(@PathVariable Long articleId) {
        commentService.deleteCommentByArticleId(articleId);
        return CommonResult.ok();
    }

    @ApiOperation("返回所有的SysLog信息")
    @GetMapping("/sys/log")
    public List<SysLog> listAllLog() {
        return sysService.listAllLog();
    }

    @ApiOperation("返回所有的SysView信息")
    @GetMapping("/sys/view")
    public List<SysView> listAllView() {
        return sysService.listAllView();
    }

    @ApiOperation("返回所有的评论信息")
    @GetMapping("/comment/list")
    public List<Comment> listAllComment() {
        return commentService.listAllComments();
    }
}