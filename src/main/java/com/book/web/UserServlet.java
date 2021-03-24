package com.book.web;

import com.book.pojo.User;
import com.book.service.UserService;
import com.book.service.impl.UserServiceImpl;
import com.book.utils.WebUtils;
import com.google.code.kaptcha.servlet.KaptchaServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class UserServlet extends BaseServlet {
    private final UserService userService =  new UserServiceImpl();
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.login(username, password);
        if (user==null){
            System.out.println("用户名或密码错误!");
            request.setAttribute("msg", "用户名或密码错误!");
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
        }else{
//            System.out.println("登录成功");
//            System.out.println(user);
            //保存用户登录信息
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request, response);
        }
    }

    /**
     * 注销登录
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //销毁Session信息
        request.getSession().invalidate();
        //重定向到首页
        response.sendRedirect(request.getContextPath());
    }

    protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取Session中的验证码
        String token = (String) request.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        //删除Session中的验证码
        request.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        //用户输入的验证码
        String code = request.getParameter("code");

        //检查验证码是否正确
        if (token!=null && token.equalsIgnoreCase(code)){
            //验证码通过了才执行注册操作
            User user = WebUtils.copyParamToBean(request.getParameterMap(), new User());

            if(userService.existsUsername(user.getUsername())){
                request.setAttribute("msg", "用户已存在!");
                request.getRequestDispatcher("/pages/user/register.jsp").forward(request, response);
            } else{
//                System.out.println("用户不存在, 执行注册");
                userService.register(user);
                request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request, response);
            }
        } else{
            request.setAttribute("msg", "验证码错误!");
            request.getRequestDispatcher("/pages/user/register.jsp").forward(request, response);
        }

    }


}
