package com.manage.mall.utils;

import java.util.UUID;

public class DealString {

    /**
     *将test.jpg => 'test'+splitSign+UUId+.+'jpg'
     * @param oFileName
     * @param splitSign
     * @return 文件名
     */
    public static String createFileName(String oFileName,String splitSign){
        // |  +  * ^ $  / | [  ] (  ) -  .  \  特殊字符需要转义
        String UUId= UUID.randomUUID().toString().replace("#","");
        String[] strs=oFileName.split("\\.");
        return splitSign+strs[0]+UUId+"."+strs[1];
    }
}
