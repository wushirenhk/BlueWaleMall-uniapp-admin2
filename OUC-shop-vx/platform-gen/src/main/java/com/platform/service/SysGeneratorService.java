package com.platform.service;

import java.util.List;
import java.util.Map;

/**
 * 代码生成器
 *
 * @author hukai
 * @email 365157138@qq.com
 * @date 2023年12月19日 下午3:33:38
 */
public interface SysGeneratorService {

    List<Map<String, Object>> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    Map<String, String> queryTable(String tableName);

    List<Map<String, String>> queryColumns(String tableName);

    /**
     * 生成代码
     */
    byte[] generatorCode(String[] tableNames);
}
