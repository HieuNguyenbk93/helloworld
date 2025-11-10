package com.exam.helloworld.admin.test;

import org.youngmonkeys.devtools.swagger.SwaggerGenerator;

public class HelloworldAdminPluginSwaggerGenerator {

    public static void main(String[] args) throws Exception {
        SwaggerGenerator swaggerGenerator = new SwaggerGenerator(
            "com.exam.helloworld.admin.controller"
        );
        swaggerGenerator.generateToDefaultFile();
    }
}
