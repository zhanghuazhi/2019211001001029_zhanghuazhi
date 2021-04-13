package zhz.week5.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();
        /// TODO 1: GET 4 CONTEXT PARAM - DRIVER ,URL,USERNAME,PASSWORD
        // TODO 2: GET JDBC connection
        con = (Connection) getServletContext().getAttribute("con");

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        //TODO 3: GET REQUEST PARAMETER - USERNAME AND PASSWORD
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //TODO 4 VALIDATE USER - SELECT *FROM USERTABLE WHERE USERNAME='XXX'
        // AND PASSWORD='YYY'
        String sql = "select username,password from usertable where username='" + username + "' and password='" + password + "'";
        try {
            ResultSet rs = null;
            try {
                rs = con.createStatement().executeQuery(sql);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            if (rs.next()) {
                //out.print("Login Successful!!!");
                //out.print("Welcome"+username);
                request.setAttribute("id", rs.getInt("id"));
                request.setAttribute("username", rs.getString("username"));
                request.setAttribute("password", rs.getString("password"));
                request.setAttribute("email", rs.getString("email"));
                request.setAttribute("gender", rs.getString("gender"));
                request.setAttribute("birthDate", rs.getString("birthdate"));
                //forward to user info jsp
                try {
                    request.getRequestDispatcher("userList.jsp").forward(request, response);
                } catch (ServletException e) {
                    e.printStackTrace();
                }
            } else {
                //out.print("Username or password Error!!!");
                request.setAttribute("massage", "Username or Password Error!!!");
                try {
                    request.getRequestDispatcher("Login.jsp").forward(request, response);
                } catch (ServletException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}