package com.exam.helloworld.web.controller.api;

import com.tvd12.ezyfox.util.EzyMapBuilder;
import com.tvd12.ezyhttp.server.core.annotation.Controller;
import com.tvd12.ezyhttp.server.core.annotation.DoGet;

@Controller("/api/v1")
public class LuckyWheelController {

    @DoGet("/helloworld")
    public Object info() {
        return EzyMapBuilder.mapBuilder()
            .put("name", "helloworld")
            .build();
    }
}
