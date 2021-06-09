package zhz.lab2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "ZHZFilter")
public class ZHZFilter implements Filter {
public void destroy() {
        }

public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("ZHZFilter -- before chain");
        chain.doFilter(req, resp);
        System.out.println("ZHZFilter -- after chain");
        }
    public void init(FilterConfig config) throws ServletException {

    }

}