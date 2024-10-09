package vn.hoaitan.services.imp;

import vn.hoaitan.dao.ICategoryDao;
import vn.hoaitan.dao.imp.CategoryDaoImpl;
import vn.hoaitan.entity.Category;
import vn.hoaitan.models.CategoryModel;
import vn.hoaitan.services.ICategoryService;

import java.util.List;

public class CategoryServiceImpl implements ICategoryService {
    ICategoryDao cateDao = new CategoryDaoImpl();





    @Override


    public int count() {





        return cateDao.count();


    }



    @Override


    public List<Category> findAll(int page, int pagesize) {





        return cateDao.findAll(page, pagesize);


    }



    @Override


    public List<Category> findByCategoryname(String catname) {





        return cateDao.findByCategoryname(catname);


    }



    @Override


    public List<Category> findAll() {





        return cateDao.findAll();


    }



    @Override


    public Category findById(int cateid) {





        return cateDao.findById(cateid);


    }



    @Override


    public void delete(int cateid) throws Exception {


        cateDao.delete(cateid);





    }



    @Override


    public void update(Category category) {


        cateDao.update(category);





    }



    @Override


    public void insert(Category category) {


        cateDao.insert(category);





    }
}
