
package com.equinooxe.resource;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.apache.shiro.web.util.WebUtils;

/**
 * Credit http://blog.awolski.com/cors-dart-dropwizard-and-shiro/
 * Chrome is sending a preflight request, which is an OPTIONS request to the other
 * domain (client-api) in order to determine whether the actual request is safe to send.
 * The OPTIONS request was being intercepted by 
 * Shiro's org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter.isAccessAllowed method,
 * which was failing because the Authorization header wasn't added to the preflight request
 * @author mboullouz
 */
public class AppCustomBasicAuthenticationFilter extends org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        HttpServletRequest httpRequest = WebUtils.toHttp(request);
        if ("OPTIONS".equals(httpRequest.getMethod())) {
            return true;
        }
        return super.isAccessAllowed(request, response, mappedValue);
    }
}
