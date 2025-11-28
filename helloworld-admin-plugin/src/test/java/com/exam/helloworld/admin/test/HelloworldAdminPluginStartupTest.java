package com.exam.helloworld.admin.test;

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
    "org.youngmonkeys.ezyarticle",
    "org.youngmonkeys.ezysupport",
    "org.youngmonkeys.ezymail",
    "org.youngmonkeys.ezycrm",
    "org.youngmonkeys.ecommerce",
    "org.youngmonkeys.graphql",
    "org.youngmonkeys.ezyaccount",
    "org.youngmonkeys.ezylogin"
})
public class HelloworldAdminPluginStartupTest {

    public static void main(String[] args) throws Exception {
        EzyHttpApplicationBootstrap.start(HelloworldAdminPluginStartupTest.class);
    }
}
