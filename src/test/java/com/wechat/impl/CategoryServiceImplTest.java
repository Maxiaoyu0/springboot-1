package com.wechat.impl;

import com.wechat.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {
    @Autowired
    private CategoryServiceImpl categoryService;
    @Test
    public void findById() {
        ProductCategory productCategory = categoryService.findById(1);
        Assert.assertEquals("热销榜",productCategory.getCategoryName());
    }

    @Test
    public void findAll() throws Exception {
        List<ProductCategory> productCategorieslist = categoryService.findAll();
//        System.out.println(productCategorieslist);

        Assert.assertNotEquals(0,productCategorieslist.size());
    }

    @Test
    public void findByCategoryTypeIn() {

        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(Arrays.asList(2,3));
        Assert.assertNotEquals(0, productCategoryList.size());



    }

    @Test
    public void save() {


        ProductCategory result = categoryService.save(new ProductCategory("大熊",6));

        Assert.assertNotNull(result);

    }
}