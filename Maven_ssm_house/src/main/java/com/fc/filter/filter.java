package com.fc.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "filter", urlPatterns = {"/*"})
public class filter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession(false);
        String uri = request.getRequestURI();
        if (uri.endsWith("/user/login") || uri.endsWith("/user/logincheck.action")) {
            chain.doFilter(request, response);
        } else if (session == null) {
            response.sendRedirect("/user/login");
        } else if (session.getAttribute("user") != null) {
            chain.doFilter(request, response);
        } else {
            response.sendRedirect("/user/login");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
