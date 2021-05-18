package com.core;

import com.util.DateUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author rumman
 * @since 5/13/21
 */
public class RequestTraceFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("######################################");
        System.out.println("RequestTraceFilter   Initialized");
        System.out.println("######################################");
    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        String requestTrace = String.format("%s [%s] [%s] %s",
                DateUtils.getCurrentTimeStamp(),
                this.getClass().getSimpleName(),
                httpServletRequest.getMethod(),
                httpServletRequest.getRequestURI());

        System.out.println(requestTrace);

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("######################################");
        System.out.println("RequestTraceFilter destroyed");
        System.out.println("######################################");
    }
}
