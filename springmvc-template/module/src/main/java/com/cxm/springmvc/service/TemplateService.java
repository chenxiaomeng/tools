package com.cxm.springmvc.service;


import com.cxm.springmvc.entity.DataTemplate;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface TemplateService {
    List<DataTemplate> list();

    PageInfo<DataTemplate> listWithPageAndOrder(Integer pageNum, Integer pageSize, List<String> order);

    List<DataTemplate> listByOwner(String owner);

    PageInfo<DataTemplate> listByOwnerWithPageAndOrder(String owner, Integer pageNum, Integer pageSize, List<String> order);

    DataTemplate listById(String id);

    List<DataTemplate> listByIds(List<String> id);

    // 最通用的查询接口
    PageInfo<DataTemplate> list(List<String> id, List<String> owner, Integer pageNum, Integer pageSize, List<String> order);

    // 单个修改
    DataTemplate save(DataTemplate dataTemplateWithBLOBs);

    // 批量修改
    List<DataTemplate> save(List<DataTemplate> dataTemplateWithBLOBs);

    // 单个删除
    int del(String id);

    // 批量删除
    int del(List<String> id);
}
