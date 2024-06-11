package com.platform.entity;

import lombok.Data;

import java.io.Serializable;


/**
 * @author hukai
 * @email 365157138@qq.com
 * @date 2017-08-15 08:03:41
 */
@Data
public class RelatedGoodsVo implements Serializable {
    private static final long serialVersionUID = 1L;

    //主键
    private Integer id;
    //商品Id
    private Integer goodsId;
    //关联商品id
    private Integer relatedGoodsId;
}