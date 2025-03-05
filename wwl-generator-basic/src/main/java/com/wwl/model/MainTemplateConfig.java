package com.wwl.model;

import lombok.Data;

/**
 * 动态模板配置
 */
@Data
public class MainTemplateConfig {
    /**
     * 作者
     */
    private String author="wwl";
    /**
     * 输出信息
     */
    private String outputText="sum";
    /**
     * 是否循环
     */
    private boolean loop;
}
