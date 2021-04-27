package zhz.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateServlet", value = "/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //TODO 1 : forward to WEB-INF/views/updateUser.jsp
        //TODO 2 :create one jsp page - update User
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //TODO 1: get all (6) request parameters
        //TODO 2: create an object of user model
        //TODO 3: set all 6 request parameters values into user model - setXXX()
        //TODO 4: create an object of UserDao
        //TODO 5: call updateUser() in UserDao

        //TODO 6: forword to WEB-INF/views/userInfo.jsp
    }
}
