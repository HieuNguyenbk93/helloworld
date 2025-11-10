package com.exam.helloworld.test;

import org.youngmonkeys.devtools.pagination.PaginationClassesGenerator;

public class HelloworldPaginationClassesGenerator {

    public static void main(String[] args) throws Exception {
        new PaginationClassesGenerator(Object.class)
            .generate();
    }
}
