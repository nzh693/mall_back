package com.manage.mall.service.imp;

import com.manage.mall.entitys.Assistant;
import com.manage.mall.mappers.IAssistantMapper;
import com.manage.mall.service.IAssistantService;
import com.manage.mall.vo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssistantsServiceImp implements IAssistantService {

    @Autowired
    private IAssistantMapper assistantMapper;


    @Override
    public Page getAssistantsByPage(Integer cur, Integer size) {
        int sIdnex = (cur - 1) * size;
        int count = assistantMapper.queryCountAssistant();
        int totalPage = (count % size) != 0 ? count / size + 1 : count / size;
        List<Assistant> assistants = assistantMapper.queryAssistantByPage(sIdnex, size);
        Page<List<Assistant>> page = new Page<>();
        page.Page(cur,size,sIdnex,count,totalPage,assistants);
        return page;
    }
}
