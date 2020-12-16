package com.uladkaminski;

import com.github.javafaker.Faker;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.DataSource;

import java.util.ArrayList;
import java.util.List;

public class BatchJobSample {
    public static void main(String[] args) {
        try {
            ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
            Faker faker = new Faker();
            List<String> products = new ArrayList<>();
            for (int i = 0; i < 100000000; i++) {
                products.add(faker.funnyName().name());
            }
//            List<String> products = Arrays.asList("Mouse", "Keyboard", "Mother Board", "Web camera");
            DataSource<String> dsProducts = env.fromCollection(products).name("SOURCE");
            dsProducts.map(String::toUpperCase).name("MAP").setParallelism(2);
            dsProducts.map(String::length).name("length");
            System.out.println(dsProducts.sum(0));

        } catch (Exception e) {
            throw e;
        }
    }
}
