package com.yigou.order.service.api;

import com.leyou.item.api.GoodsApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "yigou-gateway", path = "/api/item")
public interface GoodsService extends GoodsApi {
}
