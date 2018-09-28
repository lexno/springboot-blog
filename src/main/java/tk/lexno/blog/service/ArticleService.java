package tk.lexno.blog.service;

import tk.lexno.blog.dto.ArticleDto;
import tk.lexno.blog.entity.ArticleContent;
import tk.lexno.blog.entity.ArticleInfo;

import java.util.List;

public interface ArticleService {
    /**
     * 新增文章，包括内容
     * @param articleDto 文章详情
     */
    void addArticle(ArticleDto articleDto);

    /**
     * 更新文章内容
     * @param content 更新文章内容
     */
    void updateArticleContent(ArticleContent content);

    /**
     * 跟新文章分类
     * @param articleId 文章id
     * @param categoryId 分类id
     */
    void updateArticleCategory(Long articleId, Long categoryId);

    /**
     * 更新文章信息
     * @param articleDto 更新文章信息
     */
    void updateArticle(ArticleDto articleDto);

    /**
     * 获得文章信息
     * @param id 文章id
     */
    ArticleDto getOneById(Long id);

    /**
     * 查询所有的文章，不包含内容
     * @return 文章列表
     */
    List<ArticleInfo> findAll();

    /**
     * 根据分类id查找分类下的文章列表
     * @param id 分类id
     * @return 文章列表
     */
    List<ArticleInfo> findByCategoryId(Long id);
}
