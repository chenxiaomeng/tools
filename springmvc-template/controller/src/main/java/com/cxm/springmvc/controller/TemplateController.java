package com.cxm.springmvc.controller;

import com.cxm.springmvc.constant.CommonResponse;
import com.cxm.springmvc.service.TemplateService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.RequestContext;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class TemplateController {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private RequestContext requestContext;
    private String locale;

    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        this.requestContext = new RequestContext(request);
        this.locale = requestContext.getLocale().toString();
    }

    @Resource
    private TemplateService templateService;

    @ApiOperation(value = "获取报表列表")
    @RequestMapping(value = "/template/list", method = RequestMethod.GET)
    public CommonResponse list() {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setData(templateService.list());
        return commonResponse;
    }
//
//    @ApiOperation(value = "获取报表详情")
//    @RequestMapping(value = "/template/info/{id}", method = RequestMethod.GET)
//    public ConfRes get(@PathVariable String id) {
//        return new ConfRes(templateService.infoTemplate(id));
//    }
//
//    @ApiOperation(value = "保存报表")
//    @RequestMapping(value = "/template/save", method = RequestMethod.POST)
//    public ConfRes save(@RequestBody(required = false) DataTemplate dataTemplate) {
//        UserTokenInfo userTokenInfo = (UserTokenInfo) this.request.getAttribute("user");
//        return new ConfRes(templateService.saveTemplate(dataTemplate, userTokenInfo.getUserId(), userTokenInfo.getUsername()));
//    }
//
//    @ApiOperation(value = "删除报表")
//    @RequestMapping(value = "/template/del/{id}", method = RequestMethod.GET)
//    public ConfRes del(@PathVariable String id) {
//        UserTokenInfo userTokenInfo = (UserTokenInfo) this.request.getAttribute("user");
//        templateService.delTemplate(id, userTokenInfo.getUserId());
//        return new ConfRes();
//    }
}
