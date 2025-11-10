package com.exam.helloworld.web.test;

import com.tvd12.ezyhttp.server.core.annotation.ComponentsScan;
import com.tvd12.ezyhttp.server.core.annotation.PropertiesSources;
import org.youngmonkeys.ezyplatform.test.IntegrationTestRunner;

@PropertiesSources({
    "config.properties",
})
@ComponentsScan({
    "org.youngmonkeys.ezyplatform",
    "com.exam.helloworld"
})
public class HelloworldThemeIntegrationTestRunner {

    public static void main(String[] args) throws Exception {
        IntegrationTestRunner.run(
            HelloworldThemeIntegrationTestRunner.class
        );
    }
}
