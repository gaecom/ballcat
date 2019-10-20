package com.hccake.ballcat.codegen.config;

import lombok.Data;

import java.util.Map;
import java.util.Set;

/**
 * @author Hccake
 * 生成配置
 */
@Data
public abstract class AbstractGenConfig implements GenConfig{


    /**
     * 包名
     */
    private String packageName;
    /**
     * 作者
     */
    private String author;
    /**
     * 模块名称
     */
    private String moduleName;
    /**
     * 表前缀
     */
    private String tablePrefix;

    /**
     * column to javaType 映射关系
     */
    private Map<String, String> typeMapping;

    /**
     * 需要隐藏的列
     */
    private Set<String> hiddenColumns;

}
