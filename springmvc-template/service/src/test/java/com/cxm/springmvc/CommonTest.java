package com.cxm.springmvc;

import com.cxm.springmvc.constant.CommonConstant;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by xiaomeng.chen on 2016/11/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/applicationContext-*.xml",
        "classpath*:spring-test/applicationContext-*.xml"})
public class CommonTest {
    @Test
    public void test() {
        Assert.assertEquals(CommonConstant.SUCCESS_CODE, CommonConstant.SUCCESS_CODE);
    }
}
