package com.wwl.generator;

import com.wwl.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

public class MainGenerator {
    public static void main(String[] args) throws TemplateException, IOException {

        // 1.静态文件生成
        //文件根目录
        String propertyPath = System.getProperty("user.dir");
        //源文件目录
        String StaticInputPath=propertyPath+ File.separator+"demo-projects"+ File.separator+"acm-template";
        //输出路径
        String StaticOutputPath=propertyPath;
        //复制
        StaticGenerator.copyFilesByHutool(StaticInputPath,StaticOutputPath);

        // 2.动态文件生成         todo:文件路径问题
        //String propertyPath = System.getProperty("user.dir")+File.separator+"wwl-generator-basic";
        String DynamicInputPath = propertyPath+File.separator+"wwl-generator-basic/src/main/resources/templates/MainTemplate.java.ftl";
        String DynamicOutputPath = propertyPath+File.separator+"acm-template/src/com/yupi/acm/MainTemplate.java";
        MainTemplateConfig mainTemplateConfig=new MainTemplateConfig();
        mainTemplateConfig.setAuthor("wwl");
        mainTemplateConfig.setLoop(true);
        mainTemplateConfig.setOutputText("sum");
        DynamicGenerator.doGenerator(DynamicInputPath,DynamicOutputPath,mainTemplateConfig);
    }
}
