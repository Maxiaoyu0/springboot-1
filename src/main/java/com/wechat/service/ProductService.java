package com.wechat.service;

import com.wechat.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    ProductInfo findById(String ProductId);

    List<ProductInfo> findUpAll();

    Page<ProductInfo> findall(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    //加库存
    //减库存

}
