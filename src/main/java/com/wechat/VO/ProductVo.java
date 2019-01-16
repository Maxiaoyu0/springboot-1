package com.wechat.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @program:product
 * @description:
 * @author: M. Maxiaoyu
 * @create: 2018-12-04 18:48
 **/
@Data
public class ProductVo {
    //类目的名字,并用jsonproperty来传给前段显示为name
    @JsonProperty("name")
    private String categoryName;
    @JsonProperty("type")
    private Integer categoryType;
    @JsonProperty("list")
    private List<ProductinfoVo> productinfoVoList;
}

