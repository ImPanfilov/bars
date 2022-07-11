package com.impanfilov.bars.client;

import com.impanfilov.bars.model.Contract;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "bars", url = "${bars.url}",
        fallback = BarsClientFallback.class)

public interface BarsClient {
    @RequestMapping(method = RequestMethod.GET, value = "/getall")
    ResponseEntity<List<Contract>> getAll();


}

