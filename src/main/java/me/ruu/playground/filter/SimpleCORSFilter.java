package me.ruu.playground.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@WebFilter(urlPatterns = "/*", filterName = "SimpleCORSFilter")  //这里的“/*” 表示的是需要拦截的请求路径
public class SimpleCORSFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    /**
     * 跨域处理
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse)servletResponse;
        //允许的请求头字段
        httpResponse.setHeader("Access-Control-Allow-Headers","*");
        //是否允许后续请求携带认证信息（cookies）,该值只能是true,否则不返回
        httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
        //指定允许其他域名访问
        httpResponse.addHeader("Access-Control-Allow-Origin", "*");
        //预检结果缓存时间
        httpResponse.addHeader("Access-Control-Max-Age", "1800");
        //允许的请求类型
        httpResponse.addHeader("Access-Control-Allow-Methods","GET,POST,PUT,DELETE,OPTION");

        filterChain.doFilter(servletRequest, httpResponse);
    }

    @Override
    public void destroy() {
    }
}
