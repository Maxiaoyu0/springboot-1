package com.wechat.controller;


import com.wechat.VO.ProductVo;
import com.wechat.VO.ProductinfoVo;
import com.wechat.VO.ResultVo;
import com.wechat.dataobject.ProductCategory;
import com.wechat.dataobject.ProductInfo;
import com.wechat.service.CategoryService;
import com.wechat.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.*;

//买家商品
@RestController
@RequestMapping("/buyer/product")
public class BuyerProducteController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;


    @GetMapping("/list")
    public ResultVo list(){
        //1。查询所有的上架的商品
        List<ProductInfo> productInfoList = productService.findUpAll();
        //2。查询类目（一次性查询）
        List<Integer> categoryTypelist = new ArrayList<>();
        for (ProductInfo productInfo:productInfoList
             ) {
            categoryTypelist.add(productInfo.getCategoryType());

        }

        List<ProductCategory> productCategoryList =categoryService.findByCategoryTypeIn(categoryTypelist);




        //3。数据拼装
        List<ProductVo> productVoslist = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList
                ) {
            ProductVo productVo = new ProductVo();
            productVo.setCategoryType(productCategory.getCategoryType());
            productVo.setCategoryName(productCategory.getCategoryName());

            List<ProductinfoVo> productinfoVoList = new ArrayList<>();
            for (ProductInfo productInfo: productInfoList
                 ) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductinfoVo productinfoVo = new ProductinfoVo();
                    BeanUtils.copyProperties(productInfo,productinfoVo);
                    productinfoVoList.add(productinfoVo);
                }

            }
            productVo.setProductinfoVoList(productinfoVoList);
            productVoslist.add(productVo);
        }

        ResultVo resultVo = new ResultVo();
        resultVo.setData(productVoslist);
        resultVo.setCode(0);
        resultVo.setMsg("成功");

        return resultVo;
    }

}
