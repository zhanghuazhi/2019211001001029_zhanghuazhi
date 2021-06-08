package zhz.controller;

import zhz.dao.OrderDao;
import zhz.dao.UserDao;
import zhz.model.Order;
import zhz.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
@WebServlet(name = "AccountDetailsServlet", value = "/AccountDetailsServlet")
public class AccountDetailsServlet extends HttpServlet {
 Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();;
        con=(Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(false);
        if(session!=null&&session.getAttribute("user")!=null){
            User user=(User) session.getAttribute("user");
            int id=user.getId();
            UserDao dao=new UserDao();
            try {
                user=dao.findById(con,id);
                request.setAttribute("user",user);
                OrderDao orderDao=new OrderDao();
                List<Order> orderList=orderDao.findByUserId(con,id);
                request.setAttribute("orderList",orderList);
                request.getRequestDispatcher("WEB-INF/views/accountDetails.jsp").forward(request,response);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else {
            response.sendRedirect("login");
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
