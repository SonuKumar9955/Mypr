package com.mvc.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import com.mvc.bean.LoginBean;
import com.mvc.dao.LoginDao;


public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        String userId = request.getParameter("userName");
        String password = request.getParameter("password");

        // Set data in LoginBean
        LoginBean loginBean = new LoginBean();
        loginBean.setUserId(userId);
        loginBean.setPassword(password);

        // Create LoginDao object
        LoginDao loginDao = new LoginDao();

        // Authenticate user
        String userValidate = loginDao.authenticateUser(loginBean);

        if (userValidate.equals("SUCCESS")) {
            // Create session and redirect to Home.jsp
            HttpSession session = request.getSession(); 
            session.setAttribute("user", userId);
            request.getRequestDispatcher("/Welcome.jsp").forward(request, response);
        } else {
            request.setAttribute("errMessage", userValidate);
            request.getRequestDispatcher("/Login.jsp").forward(request, response);
        }
    }
}