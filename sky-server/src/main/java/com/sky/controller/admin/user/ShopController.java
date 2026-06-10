package com.sky.controller.admin.user;

import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController("userShopController")
@RequestMapping("/user/shop")
@Api(tags="Store-related interfaces")
@Slf4j
public class ShopController {

    public static final String KEY="SHOP_STATUS";

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 获取店铺的营业状态
     * @return
     */
   @GetMapping("/status")
   @ApiOperation("Get the store's operating status")
   public Result<Integer> getStatus(){
      Integer status=(Integer) redisTemplate.opsForValue().get(KEY);
       return Result.success(status);
   }
}
