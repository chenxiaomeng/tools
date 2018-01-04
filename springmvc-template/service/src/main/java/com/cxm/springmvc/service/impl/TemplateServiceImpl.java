package com.cxm.springmvc.service.impl;

import com.cxm.springmvc.constant.CommonConstant;
import com.cxm.springmvc.entity.DataTemplate;
import com.cxm.springmvc.entity.DataTemplateExample;
import com.cxm.springmvc.mapper.DataTemplateMapper;
import com.cxm.springmvc.service.TemplateService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Joiner;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class TemplateServiceImpl implements TemplateService {
    @Resource
    private DataTemplateMapper dataTemplateMapper;


    @Override
    public List<DataTemplate> list() {
        DataTemplateExample dataTemplateExample = new DataTemplateExample();
        dataTemplateExample.createCriteria().andIsValidEqualTo(CommonConstant.FLAG_VALID);
        return dataTemplateMapper.selectByExample(dataTemplateExample);
    }

    @Override
    public PageInfo<DataTemplate> listWithPageAndOrder(Integer pageNum, Integer pageSize, List<String> order) {
        return null;
    }

    @Override
    public List<DataTemplate> listByOwner(String owner) {
        return null;
    }

    @Override
    public PageInfo<DataTemplate> listByOwnerWithPageAndOrder(String owner, Integer pageNum, Integer pageSize, List<String> order) {
        return null;
    }

    @Override
    public DataTemplate listById(String id) {
        return null;
    }

    @Override
    public List<DataTemplate> listByIds(List<String> id) {
        return null;
    }

    @Override
    public PageInfo<DataTemplate> list(List<String> id, List<String> owner, Integer pageNum, Integer pageSize, List<String> order) {
        DataTemplateExample dataTemplateExample = new DataTemplateExample();
        DataTemplateExample.Criteria criteria = dataTemplateExample.createCriteria().andIsValidEqualTo(CommonConstant.FLAG_VALID);
        if (id != null) {
            criteria.andIdIn(id);
        }
        if (owner != null) {
            criteria.andOwnerIn(owner);
        }
        if (order != null) {
            dataTemplateExample.setOrderByClause(Joiner.on(",").join(order));
        }
        List<DataTemplate> dataTemplateList = null;
        if (pageNum != null && pageSize != null && pageNum >= 0 && pageSize >= 0) {
            PageHelper.startPage(pageNum, pageSize);
            dataTemplateList = dataTemplateMapper.selectByExample(dataTemplateExample);

        } else {
            dataTemplateList = dataTemplateMapper.selectByExample(dataTemplateExample);
        }
        return new PageInfo(dataTemplateList);
    }

    @Override
    public DataTemplate save(DataTemplate dataTemplateWithBLOBs) {
        return save(Arrays.asList(dataTemplateWithBLOBs)).get(0);
    }

    @Override
    public List<DataTemplate> save(List<DataTemplate> dataTemplateWithBLOBs) {
        for (DataTemplate dataTemplate : dataTemplateWithBLOBs) {
            if (dataTemplate.getIsDeploy() == null)
                dataTemplate.setIsDeploy(CommonConstant.FLAG_VALID);
            if (dataTemplate.getIsValid() == null)
                dataTemplate.setIsValid(CommonConstant.FLAG_VALID);
            if (dataTemplate.getAddTime() == null)
                dataTemplate.setAddTime(new Date());
            dataTemplate.setUpdateTime(new Date());
            if (dataTemplate.getId() == null) {
                dataTemplate.setId(UUID.randomUUID().toString());
                dataTemplateMapper.insert(dataTemplate);
            } else {
                dataTemplateMapper.updateByPrimaryKeySelective(dataTemplate);
            }
        }
        return dataTemplateWithBLOBs;
    }

    @Override
    public int del(String id) {
        return del(Arrays.asList(id));
    }

    @Override
    public int del(List<String> id) {
        int res = 0;
        for (String templateId : id) {
            if (templateId != null) {
                res += dataTemplateMapper.deleteByPrimaryKey(templateId);
            }
        }
        return res;
    }
}
