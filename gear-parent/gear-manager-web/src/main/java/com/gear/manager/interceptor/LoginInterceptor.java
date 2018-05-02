package com.gear.manager.interceptor;

import com.gear.common.pojo.GearResult;
import com.gear.common.utils.CookieUtils;
import com.gear.sso.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor{

    @Autowired
    private UserService userService;

    @Value("${TOKEN_KEY}")
    private String TOKEN_KEY;
    @Value("${SSO_LOGIN_URL}")
    private String SSO_LOGIN_URL;

    /**
     * 判断用户是否登陆
     * 执行方法之前，先执行此方法
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o 这个是controller方法
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        /* 执行方法之前执行此方法 */
        //1. 从cookie中取token信息
        String token = CookieUtils.getCookieValue(httpServletRequest, TOKEN_KEY);
        /*2. 如果取不到token，跳转sso登陆页面，
         * sso登陆成功之后，跳转回当前页面 */
        if (StringUtils.isBlank(token)){
            //没有取到token，token为空，设置重定向网址
            httpServletResponse.sendRedirect(SSO_LOGIN_URL);
            //拦截
            return false;
        }

        //3. 取到了token，调用sso系统的服务，判断用户是否登陆过期
        GearResult result = userService.getUserByToken(token);

        //4. 如果用户登陆已经过期，跳转到sso登陆页面
        if (result.getStatus() != 200){
            httpServletResponse.sendRedirect(SSO_LOGIN_URL);
            //拦截
            return false;
        }

        //5.取到了用户信息，放行
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        //handler执行之后，ModelAndView返回之前
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        //ModelAndView返回之后，执行，很少用到，一般做异常处理
    }
}
