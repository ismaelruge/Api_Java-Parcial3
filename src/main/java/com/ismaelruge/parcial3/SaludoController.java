package com.ismaelruge.parcial3;

import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Locale;

@RestController
@RequestMapping("/api")
public class SaludoController {

    private final MessageSource messageSource;

    public SaludoController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping("/saludo")
    public Mono<String> obtenerSaludo(
        @RequestHeader(name = "Accept-Language", required = false) String acceptLanguage,
        @RequestParam(name = "lang", required = false) String langParam
    ) {
        // Determinar el idioma a usar
        String languageCode = (langParam != null && !langParam.isBlank()) ? langParam : acceptLanguage;
        Locale locale = (languageCode != null) ? Locale.forLanguageTag(languageCode) : Locale.getDefault();

        String mensaje = messageSource.getMessage("saludoReactive.message", null, locale);
        return Mono.just(mensaje);
    }
}