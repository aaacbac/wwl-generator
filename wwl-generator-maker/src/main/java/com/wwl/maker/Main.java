package com.wwl.maker;

import com.wwl.maker.generator.main.MainGenerator;
import freemarker.template.TemplateException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws TemplateException, IOException, InterruptedException {
        MainGenerator mainGenerator=new MainGenerator();
        mainGenerator.doGenerate();

    }
}


