package com.technova.dms.commons.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Collections;


@Component
public class DMSServiceClient {

    @Autowired
    private WebClient.Builder webClientBuilder;

    public <T> Mono<T> get(String url, Class<T> response) {
        return webClient(url)
                .get()
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(response);
    }

    public WebClient webClient(String url) {
        return webClientBuilder
                .clone()
                .baseUrl(url)
                .defaultHeaders(this::createHeaders)
                //.filter(null)
                //.filter(null)
                .build();
    }

    private HttpHeaders createHeaders(HttpHeaders httpHeaders) {
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        return httpHeaders;
    }
}
