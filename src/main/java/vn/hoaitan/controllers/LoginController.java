package vn.hoaitan.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import vn.hoaitan.models.UserModel;
import vn.hoaitan.services.IUserService;
import vn.hoaitan.services.imp.UserServiceImp;
import vn.hoaitan.utils.Constant;

import java.io.IOException;
@WebServlet(urlPatterns = {"/login"})   // Định nghĩa url cho web
public class LoginController extends HttpServlet {
    // Lấy toàn bộ hàm trong service
    IUserService service = new UserServiceImp();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 3 dòng để mã hóa trang web tiếng việt nếu làm web tiếng anh thì ko cần
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");


        // Lấy tham số từ view về
        String username = req.getParameter("uname");
        String password = req.getParameter("psw");
        String remember = req.getParameter("remember");

        // Kiểm tra tham số
        boolean isRememberMe = false;
        if("on".equals(remember)){
            isRememberMe = true;
        }
        String alertMsg="";
        if(username.isEmpty() || password.isEmpty()){
            alertMsg = "Tài khoản hoặc mật khẩu không được rỗng";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
            return;
        }

        // Xử lý bài toán

        UserModel user = service.login(username, password);
        if(user!=null){
            HttpSession session = req.getSession(true);
            session.setAttribute("account", user);
            if(isRememberMe){
                saveRemeberMe(resp, username);
            }
            resp.sendRedirect(req.getContextPath()+"/waiting");
        }else{
            alertMsg =
                    "Tài khoản hoặc mật khẩu không đúng";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
        }
    }

    private void saveRemeberMe(HttpServletResponse resp, String username) {
        Cookie cookie = new Cookie(Constant.COOKIE_REMEMBER, username);
        cookie.setMaxAge(30*60);
        resp.addCookie(cookie);
    }

}
