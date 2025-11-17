package com.exam.helloworld.web.test;

import com.tvd12.ezyhttp.server.boot.EzyHttpApplicationBootstrap;
import com.tvd12.ezyhttp.server.core.annotation.ComponentsScan;
import com.tvd12.ezyhttp.server.core.annotation.PropertiesSources;

@PropertiesSources({
    "config.properties",
    "setup.properties"
})
@ComponentsScan({
    "org.youngmonkeys.ezyplatform",
    "com.exam.helloworld",
    "org.youngmonkeys.ezyarticle"
})
public class HelloworldThemeStartupTest {

    public static void main(String[] args) throws Exception {
        EzyHttpApplicationBootstrap.start(HelloworldThemeStartupTest.class);
    }
}
