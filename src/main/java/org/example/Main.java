package org.example;

import org.example.service.CharacterService;
import org.example.service.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CharacterService characterService = context.getBean(CharacterService.class);
        characterService.findUniqueCharacter();
    }
}