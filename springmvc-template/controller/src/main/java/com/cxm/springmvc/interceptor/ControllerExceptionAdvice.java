package com.cxm.springmvc.interceptor;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ControllerExceptionAdvice {
//    @ExceptionHandler(GlobalException.class)
//    @ResponseStatus(HttpStatus.OK)
//    @ResponseBody
//    public CommonResponse handleParamException(CommonException paramException, HttpServletRequest request) {
////        RequestContext requestContext = new RequestContext(request);
////        if (null == paramException.getMsg())
////            paramException.setMsg(requestContext.getMessage(ConfConstant.EXP_CODE_PREFIX + paramException.getCode()));
////        request.setAttribute(ConfConstant.VISIT_CODE, paramException);
////        return paramException;
//        CommonResponse globalExceptionMsg = new CommonResponse();
//        globalExceptionMsg.setCode(paramException.getCode());
//        globalExceptionMsg.setDetailMsg(paramException.getDetailMsg());
//        RequestContext requestContext = new RequestContext(request);
//        if (null == paramException.getMsg())
//            globalExceptionMsg.setMsg(requestContext.getMessage(ConfConstant.EXP_CODE_PREFIX + paramException.getCode()));
//        else
//            globalExceptionMsg.setMsg(paramException.getMsg());
//        request.setAttribute(ConfConstant.VISIT_CODE, paramException);
//        return globalExceptionMsg;
//    }
//
//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.OK)
//    @ResponseBody
//    public GlobalExceptionMsg handleIOException(Exception e, HttpServletRequest request) {
////        GlobalException otOpException = new GlobalException(e, ConfConstant.FAIL_CODE);
////        RequestContext requestContext = new RequestContext(request);
////        otOpException.setMsg(requestContext.getMessage(ConfConstant.EXP_CODE_PREFIX + otOpException.getCode()));
////        request.setAttribute(ConfConstant.VISIT_CODE, otOpException);
////        return otOpException;
//        GlobalException otOpException = new GlobalException(e, ConfConstant.FAIL_CODE);
//        RequestContext requestContext = new RequestContext(request);
//        otOpException.setMsg(requestContext.getMessage(ConfConstant.EXP_CODE_PREFIX + otOpException.getCode()));
//        request.setAttribute(ConfConstant.VISIT_CODE, otOpException);
//
//        GlobalExceptionMsg globalExceptionMsg = new GlobalExceptionMsg();
//        globalExceptionMsg.setCode(otOpException.getCode());
//        globalExceptionMsg.setDetailMsg(otOpException.getDetailMsg());
//        if (null == otOpException.getMsg())
//            globalExceptionMsg.setMsg(requestContext.getMessage(ConfConstant.EXP_CODE_PREFIX + otOpException.getCode()));
//        else
//            globalExceptionMsg.setMsg(otOpException.getMsg());
//        return globalExceptionMsg;
//    }
}
