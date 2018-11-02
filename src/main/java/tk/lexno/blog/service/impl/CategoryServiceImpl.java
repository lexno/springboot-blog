package tk.lexno.blog.service.impl;

import org.springframework.stereotype.Service;
import tk.lexno.blog.dao.CategoryInfoMapper;
import tk.lexno.blog.entity.CategoryInfo;
import tk.lexno.blog.entity.CategoryInfoExample;
import tk.lexno.blog.service.CategoryService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryInfoMapper infoMapper;

    @Override
    public void addCategory(CategoryInfo categoryInfo) {
        infoMapper.insertSelective(categoryInfo);
    }

    @Override
    public void deleteCategoryById(Long id) {
        CategoryInfo info = new CategoryInfo();
        info.setId(id);
        info.setDelete(Boolean.TRUE);
        infoMapper.updateByPrimaryKeySelective(info);
    }

    @Override
    public void updateCategory(CategoryInfo categoryInfo) {
        infoMapper.updateByPrimaryKeySelective(categoryInfo);
    }

    @Override
    public CategoryInfo getOneById(Long id) {
        return infoMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<CategoryInfo> findAllCategories() {
        CategoryInfoExample example = new CategoryInfoExample();
        CategoryInfoExample.Criteria criteria = example.createCriteria();
        criteria.andDeleteEqualTo(Boolean.FALSE);
        return infoMapper.selectByExample(example);
    }
}
