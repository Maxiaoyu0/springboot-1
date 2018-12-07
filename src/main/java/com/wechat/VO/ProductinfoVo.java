package com.wechat.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @program:商品详情
 * @description:
 * @author: M. Maxiaoyu
 * @create: 2018-12-04 18:55
 **/
@Data
public class ProductinfoVo {
    @JsonProperty("id")
    private String productId;

    @JsonProperty("name")
    private  String productName;

    @JsonProperty("price")
    private BigDecimal productPrice;

    @JsonProperty("description")
    private String productDescription;

    @JsonProperty("icon")
    private String productIcon;
}
