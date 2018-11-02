package tk.lexno.blog.service.impl;

import org.springframework.stereotype.Service;
import tk.lexno.blog.dao.ArticleContentMapper;
import tk.lexno.blog.dao.ArticleInfoMapper;
import tk.lexno.blog.dto.ArticleDto;
import tk.lexno.blog.entity.ArticleContent;
import tk.lexno.blog.entity.ArticleInfo;
import tk.lexno.blog.entity.ArticleInfoExample;
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
        int articleId = infoMapper.insertSelective(articleDto);
        ArticleContent content = new ArticleContent();
        content.setArticleId((long) articleId);
        content.setContent(articleDto.getContent());
        contentMapper.insertSelective(content);
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
        ArticleContent content = new ArticleContent();
        content.setArticleId(articleDto.getId());
        content.setContent(articleDto.getContent());
        contentMapper.updateContentByArticleId(content);
    }

    @Override
    public ArticleDto getOneById(Long id) {

        return infoMapper.selectArticleDtoById(id);
    }

    @Override
    public List<ArticleInfo> findAll() {
        ArticleInfoExample example = new ArticleInfoExample();
        ArticleInfoExample.Criteria criteria = example.createCriteria();
        criteria.andDeleteEqualTo(Boolean.FALSE);
        return infoMapper.selectByExample(example);
    }

    @Override
    public List<ArticleInfo> findByCategoryId(Long id) {
        ArticleInfoExample example = new ArticleInfoExample();
        ArticleInfoExample.Criteria criteria = example.createCriteria();
        criteria.andDeleteEqualTo(Boolean.FALSE);
        criteria.andCategoryIdEqualTo(id);
        return infoMapper.selectByExample(example);
    }

    @Override
    public void deleteArticleById(Long id) {
        ArticleInfo info = new ArticleInfo();
        info.setId(id);
        info.setDelete(Boolean.TRUE);
        infoMapper.updateByPrimaryKeySelective(info);
    }

    @Override
    public List<ArticleInfo> listLastest() {
        return infoMapper.selectLastest();
    }
}
