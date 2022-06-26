package com.starter.demo.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class StudentInterceptor implements HandlerInterceptor {

    private static final Logger LOG = LoggerFactory.getLogger(StudentInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LOG.info(String.format("preHandle invoked...%s:%s", request.getRequestURI(), request.getMethod()));
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        LOG.info(String.format("postHandle invoked...%s:%s", request.getRequestURI(), request.getMethod()));
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        if (ex != null) {
            LOG.info(String.format("exception in afterCompletion invoked...%s", ex.getMessage()));
        }
        LOG.info(String.format("afterCompletion invoked...%s:%s", request.getRequestURI(), request.getMethod()));
    }
}
