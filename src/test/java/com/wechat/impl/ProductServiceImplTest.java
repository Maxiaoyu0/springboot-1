package com.wechat.impl;

import com.wechat.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;


    @Test
    public void findById() {
        ProductInfo result = productService.findById("5555");
        Assert.assertEquals("5555",result.getProductId());


    }

    @Test
    public void findall() {
         Pageable pageable = PageRequest.of(0,5);
         Page<ProductInfo> pagelist =  productService.findall(pageable);
         System.out.println(pagelist.getTotalElements());
         Assert.assertNotEquals(0,pagelist);
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("1234");
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductName("皮皮虾");
        productInfo.setProductStock(55);
        productInfo.setProductDescription("营养丰富");
        productInfo.setProductIcon("http://xxxx.jpg");
        productInfo.setProductStatus(1);
        productInfo.setCategoryType(2);
        ProductInfo result =productService.save(productInfo);

        Assert.assertNotNull(result);


    }
}