package com.wwl.maker.meta;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.json.JSONUtil;

public class MetaManager {

    //双检索单例模式   全局仅存在一个
    private static volatile Meta meta;      //volatile：并发编程中用于确保多线程环境下的内存可见性
    public static Meta getMetaObject(){         //获取meta对象
        if (meta==null){
            synchronized (MetaManager.class){
                if (meta==null)
                    meta=initMeta();
            }
        }
        return meta;
    }

    private static Meta initMeta() {
        String metaJson = ResourceUtil.readUtf8Str("meta.json");
        Meta newMeta = JSONUtil.toBean(metaJson, Meta.class);
        //校验和处理默认值
        MetaValidator.doValidAndFill(newMeta);
        return newMeta;
    }


}
