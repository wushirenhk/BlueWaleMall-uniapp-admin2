package com.platform.service;

import com.platform.entity.UserLevelEntity;

import java.util.List;
import java.util.Map;

/**
 * Service接口
 *
 * @author hukai
 * @email 365157138@qq.com
 * @date 2017-08-16 16:52:22
 */
public interface UserLevelService {

    /**
     * 根据主键查询实体
     *
     * @param id 主键
     * @return 实体
     */
    UserLevelEntity queryObject(Integer id);

    /**
     * 分页查询
     *
     * @param map 参数
     * @return list
     */
    List<UserLevelEntity> queryList(Map<String, Object> map);

    /**
     * 分页统计总数
     *
     * @param map 参数
     * @return 总数
     */
    int queryTotal(Map<String, Object> map);

    /**
     * 保存实体
     *
     * @param userLevel 实体
     * @return 保存条数
     */
    int save(UserLevelEntity userLevel);

    /**
     * 根据主键更新实体
     *
     * @param userLevel 实体
     * @return 更新条数
     */
    int update(UserLevelEntity userLevel);

    /**
     * 根据主键删除
     *
     * @param id
     * @return 删除条数
     */
    int delete(Integer id);

    /**
     * 根据主键批量删除
     *
     * @param ids
     * @return 删除条数
     */
    int deleteBatch(Integer[] ids);
}
