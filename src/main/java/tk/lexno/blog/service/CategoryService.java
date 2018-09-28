//package tk.lexno.blog.service;
//
//import tk.lexno.blog.entity.ArticleCategory;
//import tk.lexno.blog.entity.CategoryInfo;
//
//import java.util.List;
//
//public interface CategoryService {
//
//    /**
//     * 新增分类
//     * @param categoryInfo 分类信息
//     */
//    void addCategory(CategoryInfo categoryInfo);
//
//    /**
//     * 删除分类
//     * @param id 分类id
//     */
//    void deleteCategoryById(Long id);
//
//    /**
//     * 修改文章与分类之间的关联
//     * @param articleCategory 关联
//     */
//    void updateArticleCategory(ArticleCategory articleCategory);
//
//    /**
//     * 修改分类信息
//     * @param categoryInfo 分类信息
//     */
//    void updateCategory(CategoryInfo categoryInfo);
//
//    /**
//     * 根据分类id查找分类
//     * @param id 分类id
//     * @return 分类信息
//     */
//    CategoryInfo getOneById(Long id);
//
//    /**
//     * 查询所有分类信息
//     * @return 所有分类信息
//     */
//    List<CategoryInfo> findAllCategories();
//}
