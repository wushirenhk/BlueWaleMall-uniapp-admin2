package com.platform.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author hukai
 * @email 365157138@qq.com
 * @date 2017-08-15 08:03:40
 */
@Data
public class FeedbackVo implements Serializable {
    private static final long serialVersionUID = 1L;

    //主键
    private Integer msgId;
    //父节点
//    private Integer parentId;
    //会员Id
    private Integer userId;
    //会员名称
    private String userName;

    //移动电话
    private String mobile;
    //类型
    private Integer feedType;
    //状态
    private Integer status;
    //详细内容
    private String content;
    //反馈时间
    private Date addTime;
}
