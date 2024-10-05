package vn.hoaitan.services.imp;

import vn.hoaitan.dao.ICategoryDao;
import vn.hoaitan.dao.imp.CategoryDaoImpl;
import vn.hoaitan.models.CategoryModel;
import vn.hoaitan.services.ICategoryService;

import java.util.List;

public class CategoryServiceImpl implements ICategoryService {
    public ICategoryDao categoryDao = new CategoryDaoImpl();
    @Override
    public List<CategoryModel> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public CategoryModel findById(int id) {
        return categoryDao.findById(id);
    }

    @Override
    public CategoryModel findByName(String name) {

        return categoryDao.findByName(name);
    }

    @Override
    public List<CategoryModel> searchByName(String keyword) {
        return categoryDao.searchByName(keyword);
    }

    @Override
    public void insert(CategoryModel category) {
        CategoryModel categoryModel = this.findByName(category.getCategoryname());
        if (categoryModel.getCategoryname() == null) {
            categoryDao.insert(category);
        }
    }

    @Override
    public void update(CategoryModel category) {
        CategoryModel categoryModel = this.findByName(category.getCategoryname());
        if (categoryModel != null) {
            categoryDao.update(category);
        }
    }

    @Override
    public void delete(int id) {
        categoryDao.delete(id);
    }

    @Override
    public void updateStatus(int id, int status) {
        categoryDao.updateStatus(id, status);
    }
}
