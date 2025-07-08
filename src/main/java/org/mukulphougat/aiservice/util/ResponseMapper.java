package org.mukulphougat.aiservice.util;

import org.mukulphougat.aiservice.entity.TranslationResponse;
import org.mukulphougat.aiservice.entity.TranslationResult;


public class ResponseMapper {
    public static TranslationResponse mapToTranslationResponse(TranslationResult res){
        TranslationResponse response=new TranslationResponse();
        response.setPrompt(res.getGivenText());
        response.setResponse(res.getTranslatedText());
        return response;
    }
}
