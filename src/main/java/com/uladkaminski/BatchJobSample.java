package com.uladkaminski;

import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.DataSource;

import java.util.Arrays;
import java.util.List;

public class BatchJobSample {
    public static void main(String[] args) {
        try {
            ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

            List<String> products = Arrays.asList("Mouse", "Keyboard", "Mother Board", "Web camera");
            DataSource<String> dsProducts = env.fromCollection(products);
            

        } catch (Exception e) {

        }
    }
}
