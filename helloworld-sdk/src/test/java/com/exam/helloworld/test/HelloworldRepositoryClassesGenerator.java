package com.exam.helloworld.test;

import org.youngmonkeys.devtools.repository.RepositoryClassesGenerator;

public class HelloworldRepositoryClassesGenerator {

    public static void main(String[] args) throws Exception {
        new RepositoryClassesGenerator(Object.class)
            .generate();
    }
}
