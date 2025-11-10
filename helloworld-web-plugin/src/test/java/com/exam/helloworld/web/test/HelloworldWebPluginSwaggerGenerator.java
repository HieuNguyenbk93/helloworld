package com.exam.helloworld.web.test;

import org.youngmonkeys.devtools.swagger.SwaggerGenerator;

public class HelloworldWebPluginSwaggerGenerator {

    public static void main(String[] args) throws Exception {
        SwaggerGenerator swaggerGenerator = new SwaggerGenerator(
            "com.exam.helloworld.web.controller"
        );
        swaggerGenerator.generateToDefaultFile();
    }
}
