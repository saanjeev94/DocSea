package org.itglance.docsea.config;

import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by sanj__000 on 5/24/2017.
 */

public class helloFilter  extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        System.out.println("filter executed*************************");
        chain.doFilter(request, response);
    }


}
