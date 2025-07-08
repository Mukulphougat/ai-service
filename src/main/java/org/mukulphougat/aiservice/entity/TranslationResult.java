package org.mukulphougat.aiservice.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TranslationResult {
    private String givenText;
    private String language;
    private String translatedText;
}
