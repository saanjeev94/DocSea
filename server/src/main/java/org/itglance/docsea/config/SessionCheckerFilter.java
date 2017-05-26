package org.itglance.docsea.config;

import org.itglance.docsea.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sanj__000 on 5/24/2017.
 */
@Component
public class SessionCheckerFilter extends GenericFilterBean {

    @Autowired
    private SessionService sessionService;




    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {


        String method = ((HttpServletRequest) request).getMethod();
        System.out.println("****************Token checking*****************");
        System.out.println(method);
        if(method.equals("POST")  || method.equals("PUT")) {
            HttpServletRequest req = (HttpServletRequest) request;
            String token = req.getHeader("Authorization");
            if (token.equals("")) {
                HttpServletResponse httpResponse = (HttpServletResponse) response;
                httpResponse.setContentType("application/json");
                httpResponse.sendError(HttpServletResponse.SC_BAD_REQUEST, "Required header (Authorization) not specified in the request");

                return;
            } else if (sessionService.checkSession(token) == null) {
                HttpServletResponse httpResponse = (HttpServletResponse) response;
                httpResponse.setContentType("application/json");
                httpResponse.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid Token");
            }
            System.out.println("****************Token checked*****************");
        }
        chain.doFilter(request, response);
    }


}
