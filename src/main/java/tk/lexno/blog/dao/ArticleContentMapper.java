package tk.lexno.blog.dao;

import java.util.List;
import tk.lexno.blog.entity.ArticleContent;
import tk.lexno.blog.entity.ArticleContentExample;

public interface ArticleContentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ArticleContent record);

    int insertSelective(ArticleContent record);

    List<ArticleContent> selectByExampleWithBLOBs(ArticleContentExample example);

    List<ArticleContent> selectByExample(ArticleContentExample example);

    ArticleContent selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ArticleContent record);

    int updateByPrimaryKeyWithBLOBs(ArticleContent record);

    int updateByPrimaryKey(ArticleContent record);

    ArticleContent selectByArticleId(Long id);

    int updateContentByArticleId(ArticleContent content);
}