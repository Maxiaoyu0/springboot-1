package com.wechat.service;

import com.wechat.dataobject.ProductCategory;

import java.util.List;

public interface CategoryService {
    ProductCategory findById(Integer categoryId);


    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTyoeList);

    ProductCategory save(ProductCategory productCategory);
}
