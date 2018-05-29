package com.springboot.tongyuyan.selfhelp.config.Interceptor;

import com.springboot.tongyuyan.selfhelp.service.user.UserTokenService;
import com.springboot.tongyuyan.selfhelp.tool.config.TimeTool;
import com.springboot.tongyuyan.selfhelp.winter.model.user.UserToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class MyInterceptor implements HandlerInterceptor {
    Logger logger = LoggerFactory.getLogger(MyInterceptor.class);

    @Autowired
    private UserTokenService userTokenService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {

        // TODO Auto-generated method stub
        logger.info("------preHandle------");
        String token= request.getHeader("Access-Token");
        UserToken userToken= userTokenService.queryByToken(token);
        if(userToken!=null){
            if (userToken.getTokenDisabledTime().compareTo(TimeTool.gettime()) > 0) {
                return true;
            }
        }

        response.sendRedirect(request.getContextPath()+"/appLogin/login");
        return false;


    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
