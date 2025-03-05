package com.wwl.generator;

import cn.hutool.core.io.FileUtil;

import java.io.File;

/**
 * 静态文件生成
 */
public class StaticGenerator {
    public static void main(String[] args) {
        //文件根目录
        String property = System.getProperty("user.dir");
        //源文件目录
        String inputPath=property+File.separator+"demo-projects"+ File.separator+"acm-template";
        //输出路径
        String outputPath=property;
        //复制
        copyFilesByHutool(inputPath,outputPath);
    }
    /**
     * 拷贝文件（Hutool 实现，会将输入目录完整拷贝到输出目录下）
     * @param inputPath
     * @param outputPath
     */
    public static void copyFilesByHutool(String inputPath, String outputPath) {
        FileUtil.copy(inputPath, outputPath, true);
    }

}
