package vn.hoaitan.controllers.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import vn.hoaitan.models.CategoryModel;
import vn.hoaitan.services.ICategoryService;
import vn.hoaitan.services.imp.CategoryServiceImpl;
import vn.hoaitan.utils.Constant;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
@WebServlet(urlPatterns = {"/admin/categories","/admin/category/add","/admin/category/insert","/admin/category/edit","/admin/category/update","/admin/category/delete"})
public class CategoryController extends HttpServlet {

    public ICategoryService categoryService = new CategoryServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String url = req.getRequestURI();
        if(url.contains("/admin/categories")){
            List<CategoryModel> list = categoryService.findAll();
            req.setAttribute("listCate", list);
            req.getRequestDispatcher("/views/admin/category-list.jsp").forward(req, resp);
        }
        else if(url.contains("/admin/category/add")){
            req.getRequestDispatcher("/views/admin/category-add.jsp").forward(req, resp);
        } else if (url.contains("/admin/category/edit")) {
            int id  = Integer.parseInt(req.getParameter("id"));
            CategoryModel category = categoryService.findById(id);
            req.setAttribute("cate", category);
            req.getRequestDispatcher("/views/admin/category-edit.jsp").forward(req, resp);
        } else if (url.contains("/admin/category/delete")) {
            int id  = Integer.parseInt(req.getParameter("id"));
            categoryService.delete((id));
            req.getRequestDispatcher("/admin/categories").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String url = req.getRequestURI();
        if(url.contains("/admin/category/insert")){

            String categoryName = req.getParameter("categoryname");
            String image1 = req.getParameter("image1");
            String image = req.getParameter("image");
            int status = Integer.parseInt(req.getParameter("status"));

            // dua du lieu vao model
            CategoryModel category = new CategoryModel();
            category.setCategoryname(categoryName);
            category.setStatus(status);

            String fname = "";
            String uploadPath = Constant.UPLOAD_DIRECTORY;
            File uploadDir = new File(uploadPath);
            if(!uploadDir.exists()){
                uploadDir.mkdirs();
            }
            try{
                Part part = req.getPart("image1");
                if(part.getSize() > 0){
                    String fileName =Paths.get(part.getSubmittedFileName()).getFileName().toString();
                    // Doi ten file
                    int index = fileName.lastIndexOf(".");
                    String ext = fileName.substring(index + 1);
                    fname = System.currentTimeMillis()+ "." + ext;
                    // upload file
                    part.write(uploadPath+"/"+fname);
                    // Ghi file vao data
                    category.setImage(fname);
                }else if (image !=null) {
                    category.setImage(image);
                } else {
                    category.setImage("avatar.png");
                }
            }catch (Exception e)
            {
                e.printStackTrace();
            }
            categoryService.insert(category);


            // Tra ve view
            resp.sendRedirect(req.getContextPath()+"/admin/categories");
        } else if(url.contains("/admin/category/update")){
            CategoryModel category = new CategoryModel();
            int categoryid = Integer.parseInt(req.getParameter("categoryid"));
            String categoryname = req.getParameter("categoryname");
            int status = Integer.parseInt(req.getParameter("status"));
            // Luu hinh anh cu
            CategoryModel cateOld = categoryService.findById(categoryid);
            String fileOld = cateOld.getImage();
            // Upload file image
            String fname = "";
            String uploadPath = Constant.UPLOAD_DIRECTORY;
            File uploadDir = new File(uploadPath);
            if(!uploadDir.exists()){
                uploadDir.mkdirs();
            }
            try{
                Part part = req.getPart("image1");
                if(part.getSize() > 0){
                    String fileName =Paths.get(part.getSubmittedFileName()).getFileName().toString();
                    // Doi ten file
                    int index = fileName.lastIndexOf(".");
                    String ext = fileName.substring(index + 1);
                    fname = System.currentTimeMillis()+ "." + ext;
                    // upload file
                    part.write(uploadPath+"/"+fname);
                    // Ghi file vao data
                    category.setImage(fname);
                } else {
                    category.setImage(fileOld);
                }
            }catch (Exception e)
            {
                e.printStackTrace();
            }


            category.setCategoryid(categoryid);
            category.setCategoryname(categoryname);
            category.setStatus(status);
            categoryService.update(category);

            // Tra ve view
            resp.sendRedirect(req.getContextPath()+"/admin/categories");
        }
    }
}
