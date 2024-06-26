package com.platform.service;

import com.platform.entity.CommentPictureEntity;

import java.util.List;
import java.util.Map;

/**
 * 评价图片Service接口
 *
 * @author hukai
 * @email 365157138@qq.com
 * @date 2017-08-29 14:45:55
 */
public interface CommentPictureService {

    /**
     * 根据主键查询实体
     *
     * @param id 主键
     * @return 实体
     */
    CommentPictureEntity queryObject(Integer id);

    /**
     * 分页查询
     *
     * @param map 参数
     * @return list
     */
    List<CommentPictureEntity> queryList(Map<String, Object> map);

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
     * @param commentPicture 实体
     * @return 保存条数
     */
    int save(CommentPictureEntity commentPicture);

    /**
     * 根据主键更新实体
     *
     * @param commentPicture 实体
     * @return 更新条数
     */
    int update(CommentPictureEntity commentPicture);

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

    /**
     * 根据commentId删除
     *
     * @param commentId
     * @return 删除条数
     */
    int deleteByCommentId(Integer commentId);
}
