package tk.lexno.blog.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import tk.lexno.blog.entity.CategoryInfo;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
	
	/**
	 * 获取所有分类信息
	 * @return
	 */
	@ApiOperation("获取所有分类信息")
	@GetMapping("/list")
	public List<CategoryInfo> listAllCategoryInfo() {
		return null;
	}
	
	/**
	 * 获取某一条分类信息
	 * @param id 分类ID
	 * @return
	 */
	@ApiOperation("获取某一条分类信息")
	@ApiImplicitParam(name = "id", value = "分类ID", required = true, dataType = "Long")
	@GetMapping("/{id}")
	public CategoryInfo getCategoryInfoById(@PathVariable Long id) {
		return null;
	}
	
	/**
	 * 更新/编辑某一条分类信息
	 * @param id 分类ID
	 * @return
	 */
	@ApiOperation("更新/编辑某一条分类信息")
	@ApiImplicitParam(name = "id", value = "分类ID", required = true, dataType = "Long")
	@PostMapping("/{id}")
	public String updateCategoryInfoById(@PathVariable Long id) {
		return null;
	}
	
	/**
	 * 增加分类信息
	 * @return
	 */
	@ApiOperation("增加分类信息")
    @ApiImplicitParam(name = "name", value = "分类名称", required = true, dataType = "String")
    @PostMapping("/add")
    public String addCategoryInfo() {
        return null;
    }

	/**
	 * 删除分类信息
	 * @param id
	 * @return
	 */
	@ApiOperation("删除分类信息")
    @ApiImplicitParam(name = "id", value = "分类ID", required = true, dataType = "Long")
    @DeleteMapping("/{id}")
    public String deleteCategoryInfo(@PathVariable Long id) {
        return null;
    }
}
