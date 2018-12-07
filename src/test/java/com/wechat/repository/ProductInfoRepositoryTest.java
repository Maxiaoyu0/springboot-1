package com.wechat.repository;

import com.wechat.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    ProductInfoRepository productInfoRepository;

    @Test
    public void savaTest(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("5555");
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductName("鱼香肉丝");
        productInfo.setProductStock(55);
        productInfo.setProductDescription("营养丰富");
        productInfo.setProductIcon("http://xxxx.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(2);
        ProductInfo result = productInfoRepository.save(productInfo);

        Assert.assertNotNull(result);


    }
    @Test
    public void findByProductStatus()throws Exception{


      List<ProductInfo> list = productInfoRepository.findByProductStatus(0);
        Assert.assertNotEquals(0,list.size());

    }


}