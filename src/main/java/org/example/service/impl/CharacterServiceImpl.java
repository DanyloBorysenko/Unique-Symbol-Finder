package org.example.service.impl;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import org.example.service.CharacterService;
import org.example.service.InputService;
import org.example.service.PrintService;
import org.springframework.stereotype.Service;

@Service
public class CharacterServiceImpl implements CharacterService {
    private final InputService inputService;
    private final PrintService printService;

    public CharacterServiceImpl(InputService inputService, PrintService printService) {
        this.inputService = inputService;
        this.printService = printService;
    }

    @Override
    public String findUniqueCharacter() {
        String text = inputService.getData();
        StringBuilder uniqueCharacters = new StringBuilder();
        String[] words = text.split("\\s+");
        Arrays.stream(words)
                .map(word -> word.replaceAll("[^A-Za-z]", ""))
                .filter(word -> !word.isEmpty())
                .map(this::findFirstUniqueCharacter)
                .filter(word -> !word.isEmpty())
                .forEach(uniqueCharacters::append);
        String uniqueCharacter = findFirstUniqueCharacter(uniqueCharacters.toString());
        printService.printResult(uniqueCharacter);
        return uniqueCharacter;
    }

    private String findFirstUniqueCharacter(String word) {
        Map<Character, Integer> characterCounts = new LinkedHashMap<>();
        for (char c : word.toCharArray()) {
            characterCounts.put(c, characterCounts.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : characterCounts.entrySet()) {
            if (entry.getValue() == 1) {
                return String.valueOf(entry.getKey());
            }
        }
        return "";
    }
}
