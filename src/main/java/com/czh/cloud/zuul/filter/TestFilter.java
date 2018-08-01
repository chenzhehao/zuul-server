package com.czh.cloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: zhehao.chen
 * @version: V1.0
 * @Description:
 * @date: 2018/8/1 10:03
 */
@Component
public class TestFilter extends ZuulFilter {
    private static Logger logger = LoggerFactory.getLogger(TestFilter.class);

    /**
     * filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
     *      * pre：路由之前
     *      * routing：路由之时
     *      * post： 路由之后
     *      * error：发送错误调用
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * filterOrder：过滤的顺序,优先级为0，数字越大，优先级越低
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * shouldFilter：这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * run：过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        //可以在此处修改或者添加参数、头信息等各种内容
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.addZuulRequestHeader("content-type", "application/json;charset=utf-8");
        HttpServletRequest request = ctx.getRequest();
        logger.info("params:" + ctx.getRequestQueryParams());
        logger.info("contentLength:" + ctx.getRequest().getContentLength());
        logger.info("contentType:" + ctx.getRequest().getContentType());
        return null;
    }
}
