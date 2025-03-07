package com.wwl.maker.generator.file;

import com.wwl.maker.model.DataModel;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

public class FileGenerator {
    public static void main(String[] args) throws TemplateException, IOException {
        DataModel dataModel =new DataModel();
        dataModel.setAuthor("wwl");
        dataModel.setLoop(true);
        dataModel.setOutputText("sum");
        doGenerate(dataModel);
    }
    public static void doGenerate(Object model) throws TemplateException, IOException {
        // 1.静态文件生成
        //文件根目录
        String propertyPath = System.getProperty("user.dir");
        System.out.println("user.dir路径"+propertyPath);
        //源文件目录
        String StaticInputPath=propertyPath+ File.separator+"demo-projects"+ File.separator+"acm-template";
        //输出路径
        String StaticOutputPath=propertyPath;
        System.out.println("静态文件生成input"+StaticInputPath);
        System.out.println("静态文件生成output"+StaticOutputPath);
        //复制
        StaticFileGenerator.copyFilesByHutool(StaticInputPath,StaticOutputPath);

        // 2.动态文件生成         todo:文件路径问题
        //String propertyPath = System.getProperty("user.dir")+File.separator+"wwl-generator-maker";
        String DynamicInputPath = propertyPath+File.separator+"wwl-generator-maker/src/main/resources/templates/MainTemplate.java.ftl";
        String DynamicOutputPath = propertyPath+File.separator+"acm-template/src/com/yupi/acm/MainTemplate.java";
        System.out.println("动态文件生成input"+DynamicInputPath);
        System.out.println("动态文件生成output"+DynamicOutputPath);
        DynamicFileGenerator.doGenerate(DynamicInputPath,DynamicOutputPath,model);
    }
}
