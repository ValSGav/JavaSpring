package ru.gb.spring_demo;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init( filterConfig );
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if(servletRequest instanceof HttpServletRequest httpServletRequest ){
            String requestURI = httpServletRequest.getRequestURI();
            log.info( "Income request: {}", requestURI);
            if(requestURI.startsWith( "/admin" )){
                ((HttpServletResponse) servletResponse).sendError( 403 );
            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        } else{
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
