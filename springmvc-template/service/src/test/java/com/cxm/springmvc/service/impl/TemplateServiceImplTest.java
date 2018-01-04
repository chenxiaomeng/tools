package com.cxm.springmvc.service.impl;

import com.cxm.springmvc.CommonTest;
import com.cxm.springmvc.entity.DataTemplate;
import com.cxm.springmvc.service.TemplateService;
import com.github.pagehelper.PageInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class TemplateServiceImplTest extends CommonTest {
    @Autowired
    @Qualifier("templateServiceImpl")
    private TemplateService templateService;

    @Test
    public void test() {
        DataTemplate dataTemplate1 = new DataTemplate();
        dataTemplate1.setNameZh("abc1");
        templateService.save(dataTemplate1);
        DataTemplate dataTemplate2 = new DataTemplate();
        dataTemplate2.setNameZh("abc2");
        templateService.save(dataTemplate2);
        DataTemplate dataTemplate3 = new DataTemplate();
        dataTemplate3.setNameZh("abc3");
        templateService.save(dataTemplate3);
        DataTemplate dataTemplate4 = new DataTemplate();
        dataTemplate4.setNameZh("abc4");
        templateService.save(dataTemplate4);
        DataTemplate dataTemplate5 = new DataTemplate();
        dataTemplate5.setNameZh("abc5");
        templateService.save(dataTemplate5);

        PageInfo res = templateService.list(null, null, 1, 2, null);
        Assert.assertEquals(1, res.getPageNum());
        Assert.assertEquals(2, res.getPageSize());
        Assert.assertEquals(2, res.getList().size());
    }
}
