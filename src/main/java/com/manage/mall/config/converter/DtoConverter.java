package com.manage.mall.config.converter;


import org.springframework.cglib.core.Converter;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Po层转化为Dto
 */
public class DtoConverter implements Converter {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Object convert(Object value, Class target, Object context) {
        if("setAcount".equals(context)){
            if(! StringUtils.hasText((String) value)){
                return false;
            }
            return true;
        }
        if("setAttrs".equals(context)){
            Map<String, String> attrMap = (Map<String, String>) value;
            if(attrMap.isEmpty()){
                return null;
            }
            List<String> result = new ArrayList<>();
            for(Map.Entry<String, String> entry : attrMap.entrySet()){
                result.add(entry.getKey() + "-" + entry.getValue());
            }
            return result;
        }
        return value;
    }
}
