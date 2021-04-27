package zhz.week5.demo;

import zhz.dao.UserDao;
import zhz.model.User;

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

        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String name = request.getParameter("name");
            String password= request.getParameter("password");
            try {
                UserDao userDao=new UserDao();
                User user= userDao.findByUsernamePassword(con ,name,password);
                if(user!=null){
                    //add code for remember me
                    String rememberMe=request.getParameter("rememberMe");
                    if (rememberMe!=null && rememberMe.equals("1")){
                        Cookie usernameCookie=new Cookie("cUsername",user.getUsername());
                        Cookie passwordCookie=new Cookie("cPassword",user.getPassword());
                        Cookie rememberMeCookie=new Cookie("cRememberMe",rememberMe);

                        usernameCookie.setMaxAge(5);
                        passwordCookie.setMaxAge(5);
                        rememberMeCookie.setMaxAge(5);
                        response.addCookie(usernameCookie);
                        response.addCookie(passwordCookie);
                        response.addCookie(rememberMeCookie);
                    }
                    //valid-- login
                    //week 8 code - demo #1-use cookie for session
                    // create cookie
                    //step 1: creat an object of cookie class
                    Cookie c=new Cookie("sessionid",""+user.getID());
                    //step 2: set age of cookie
                    c.setMaxAge(10*60);//in sec- 10min -7days - 7*24**60*60
                    //step3 :add cookie into response
                      response.addCookie(c);
                      //creat session
                      HttpSession session=request.getSession();
                        System.out.println("session id-->"+session.getId());
                        session.setMaxInactiveInterval(10);


                    session.setAttribute("user",user);
                    request.getRequestDispatcher("WEB-INF/views/userinfo.jsp").forward(request,response);
                }else{
                    request.setAttribute("msg" ,"username or password Error");
                    request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response); }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            System.out.println(name + password);
            System.out.println(con);
        PrintWriter out = response.getWriter();
        //TODO 3: GET REQUEST PARAMETER - USERNAME AND PASSWORD
        String username = request.getParameter("username");
        password = request.getParameter("password");
        //TODO 4 VALIDATE USER - SELECT *FROM USERTABLE WHERE USERNAME='XXX'
        // AND PASSWORD='YYY'
       /* String sql = "select username,password from usertable where username='" + username + "' and password='" + password + "'";
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
        }*/

    }
}