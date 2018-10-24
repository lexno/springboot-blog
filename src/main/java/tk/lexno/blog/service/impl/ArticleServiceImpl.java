package tk.lexno.blog.service.impl;

import org.springframework.stereotype.Service;
import tk.lexno.blog.dao.ArticleContentMapper;
import tk.lexno.blog.dao.ArticleInfoMapper;
import tk.lexno.blog.dto.ArticleDto;
import tk.lexno.blog.entity.ArticleContent;
import tk.lexno.blog.entity.ArticleInfo;
import tk.lexno.blog.service.ArticleService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleContentMapper contentMapper;

    @Resource
    private ArticleInfoMapper infoMapper;

    @Override
    public void addArticle(ArticleDto articleDto) {

    }

    @Override
    public void updateArticleContent(ArticleContent content) {
        contentMapper.updateByPrimaryKeySelective(content);
    }

    @Override
    public void updateArticleCategory(Long articleId, Long categoryId) {
        ArticleInfo info = new ArticleInfo();
        info.setCategoryId(categoryId);
        info.setId(articleId);
        infoMapper.updateByPrimaryKeySelective(info);
    }

    @Override
    public void updateArticle(ArticleDto articleDto) {
        infoMapper.updateByPrimaryKeySelective(articleDto);

    }

    @Override
    public ArticleDto getOneById(Long id) {

        return null;
    }

    @Override
    public List<ArticleInfo> findAll() {
        return null;
    }

    @Override
    public List<ArticleInfo> findByCategoryId(Long id) {
        return null;
    }

    @Override
    public void deleteArticleById(Long id) {

    }

    @Override
    public List<ArticleInfo> listLastest() {
        return null;
    }
}
