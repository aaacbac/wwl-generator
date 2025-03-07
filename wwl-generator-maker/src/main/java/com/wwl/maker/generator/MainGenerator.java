package com.wwl.maker.generator;

import com.wwl.maker.meta.Meta;
import com.wwl.maker.meta.MetaManager;

public class MainGenerator {
    public static void main(String[] args) {
        Meta meta=MetaManager.getMetaObject();
        System.out.println(meta);

    }
}
