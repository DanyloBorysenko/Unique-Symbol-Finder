package org.example.service.impl;

import java.util.Scanner;
import org.example.service.InputService;
import org.springframework.stereotype.Component;

@Component
public class InputServiceImpl implements InputService {
    @Override
    public String getData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the text (press Enter twice to finish):");
        StringBuilder inputText = new StringBuilder();
        String line;
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }
            inputText.append(line).append("\n");
        }
        return inputText.toString();
    }
}
