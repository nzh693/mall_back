package com.manage.mall.service;

import com.manage.mall.vo.Page;
import org.springframework.stereotype.Service;

public interface IAssistantService {

    /**
     * 分页查询
     * @param cur
     * @param size
     * @return
     */
    public Page getAssistantsByPage(Integer cur,Integer size);
}
