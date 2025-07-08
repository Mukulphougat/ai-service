package org.mukulphougat.aiservice.controller;

import org.mukulphougat.aiservice.entity.TranslationResponse;
import org.mukulphougat.aiservice.service.AiTranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class AiController {
    @Autowired
    private AiTranslationService translationService;
    @GetMapping("/greet")
    private String sayHello(){
        return "Hello World!";
    }
    @GetMapping("/translate")
    private ResponseEntity<TranslationResponse> translate(@RequestParam String text){
        TranslationResponse response=translationService.translateToHindi(text);
        return ResponseEntity.ok(response);
    }
}
