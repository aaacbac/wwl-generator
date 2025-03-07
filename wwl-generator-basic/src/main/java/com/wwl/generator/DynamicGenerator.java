package com.wwl.generator;

import com.wwl.model.MainTemplateConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Objects;

/**
 * 动态文件生成器
 */
public class DynamicGenerator {
    public static void main(String[] args) throws TemplateException, IOException {
        String propertyPath = System.getProperty("user.dir")+File.separator+"wwl-generator-basic";
        String inputPath = propertyPath+File.separator+"src/main/resources/templates/MainTemplate.java.ftl";
        String outputPath = propertyPath+File.separator+"MainTemplate.java";
        MainTemplateConfig mainTemplateConfig=new MainTemplateConfig();
        mainTemplateConfig.setAuthor("wwl");
        mainTemplateConfig.setLoop(true);
        mainTemplateConfig.setOutputText("总和为");
        doGenerate(inputPath,outputPath,mainTemplateConfig);


    }
    public static void doGenerate(String inputPath, String outputPath, Object model) throws IOException, TemplateException {
        // new 出 Configuration 对象，参数为 FreeMarker 版本号
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);

        // 指定模板文件所在的目录
        File templatePath=new File(inputPath).getParentFile();
        configuration.setDirectoryForTemplateLoading(templatePath);

        // 设置模板文件使用的字符集
        configuration.setDefaultEncoding("utf-8");

        configuration.setNumberFormat("0.######");

        // 创建模板对象，加载指定模板
        String templateName=new File(inputPath).getName();
        Template template = configuration.getTemplate(templateName);

        Writer out = new FileWriter(outputPath);

        template.process(model, out);

        // 生成文件后别忘了关闭哦
        out.close();
    }
}
