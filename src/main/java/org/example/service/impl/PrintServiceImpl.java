package org.example.service.impl;

import org.example.service.PrintService;
import org.springframework.stereotype.Component;

@Component
public class PrintServiceImpl implements PrintService {
    private static final String RESULT_FIELD_NAME = "First unique symbol : ";
    @Override
    public void printResult(String data) {
        System.out.println(RESULT_FIELD_NAME + data);
    }
}
