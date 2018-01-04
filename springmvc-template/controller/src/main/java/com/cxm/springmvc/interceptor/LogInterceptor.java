package com.cxm.springmvc.interceptor;

import com.cxm.springmvc.constant.CommonConstant;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

public class LogInterceptor extends HandlerInterceptorAdapter {
    private static Logger logger = LogManager.getLogger(LogInterceptor.class);

    //    /*登录失败的响应*/
//    private void loginFailResponse(HttpServletRequest request, HttpServletResponse response, String msg) {
//        try {
//            String fullMsg = String.format("{\"code\":30000,\"msg\":\"please sign in\" ,\"detail\":\"%s\", \"logoutHref\":\"%s\"}",
//                    msg == null ? "" : msg, lionUtil.getValue(ConfConstant.LOGOUT_HREF));
//            String sessionId = ConfCommonUtil.getSessionId(request);
//            response.setContentType("application/json");
//            response.getWriter().write(fullMsg);
//            if (StringUtils.isNotEmpty(sessionId))
//                logger.info(sessionId + " login fail!");
//            else
//                logger.info("not login!");
//        } catch (Exception e) {
//            logger.error(e);
//            Cat.logError(e);
//        }
//    }
//
//    private Boolean isLogin(HttpServletRequest request, HttpServletResponse response) {
//        try {
//            String sessionId = ConfCommonUtil.getSessionId(request);
//            String msg = "sessionId: " + sessionId + " not login!";
//            if (eosLoginServer.isLogin(sessionId)) {
//                UserTokenInfo userTokenInfo = eosLoginServer.getUserTokenInfo(sessionId);
//                if (userTokenInfo != null) {
//                    request.setAttribute("user", userTokenInfo);
//                    request.setAttribute(ConfConstant.TEMPLATE_OWNER_KEY, userTokenInfo.getUsername());
//                    logger.debug("current user:" + (new Gson()).toJson(userTokenInfo));
//                    return true;
//                } else {
//                    msg = "sessionId: " + sessionId + " get user token info fail!";
//                }
//            }
//            loginFailResponse(request, response, msg);
//        } catch (Exception e) {
//            logger.error(e);
//            loginFailResponse(request, response, "login fail!");
//            Cat.logError(e);
//        }
//        return false;
//    }
//
//    private String getGlobalKey() {
//        return CHECK_SESSION_URL.contains(ConfConstant.PORTAL_REQUEST_URL) ? ConfConstant.PORTAL_GLOBAL_ID : (CHECK_SESSION_URL.contains(ConfConstant.SCADA_REQUEST_URL) ? ConfConstant.SCADA_GLOBAL_ID : "sessionId");
//    }
//
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        VisitLog visitLog = new VisitLog(request);
        request.setAttribute(CommonConstant.VISIT_USER, visitLog);
        logger.info(visitLog.logBegin());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        VisitLog visitLog = (VisitLog) request.getAttribute(CommonConstant.VISIT_USER);
        if (ex != null) {
            logger.error(visitLog.logEnd());
        } else {
            logger.info(visitLog.logEnd());
        }
    }

    private class VisitLog {
        private String uuid;
        private String ip;
        private String path;
        private long startTime;

        private final String[] PROXY_REMOTE_IP_ADDRESS = {"X-Forwarded-For", "X-Real-IP"};

        VisitLog(HttpServletRequest request) {
            this.uuid = UUID.randomUUID().toString();
            this.startTime = System.currentTimeMillis();
            this.ip = getRemoteIp(request);
            this.path = visitPath(request);
        }

        private String getRemoteIp(HttpServletRequest request) {
            for (int i = 0; i < PROXY_REMOTE_IP_ADDRESS.length; i++) {
                String ip = request.getHeader(PROXY_REMOTE_IP_ADDRESS[i]);
                if (StringUtils.isNotBlank(ip)) {
                    return getRemoteIpFromForward(ip.trim());
                }
            }
            return request.getRemoteHost();
        }

        private String getRemoteIpFromForward(String xforwardIp) {
            int commaOffset = xforwardIp.indexOf(',');
            if (commaOffset < 0) {
                return xforwardIp;
            }
            return xforwardIp.substring(0, commaOffset);
        }

        String visitPath(HttpServletRequest request) {
            return request.getPathInfo();
        }

        long visitTimeSpend() {
            return System.currentTimeMillis() - this.startTime;
        }

        String logBegin() {
            return String.format("begin visit: {uuid:%s, ip:%s, startTime:%s, path:%s}", uuid, ip, startTime, path);
        }

        String logEnd() {
            return String.format("end visit: {uuid:%s, ip:%s, startTime:%s, timeSpend: %s, path:%s}", uuid, ip, startTime, visitTimeSpend(), path);
        }
    }
}
