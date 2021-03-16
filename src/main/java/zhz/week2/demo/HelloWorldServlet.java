package zhz.week2.demo;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//now its just a java class
//extend Httpservlet
public class HelloWorldServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //when client request method is GET -here - inside doGet()
        //we want to send Hello to client
        //we want to write Hello in response
        //get writer-java.io
        PrintWriter writer = response.getWriter();
        writer.println("Hello client !!!");// that all
        //next we need to tell about this servlet to tomcat - how ? - web.xml
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)  {
        //when client request method is GET -here - inside doPost()

    }
}