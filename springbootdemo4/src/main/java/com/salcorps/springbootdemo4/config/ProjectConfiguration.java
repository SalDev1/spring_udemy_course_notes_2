package com.salcorps.springbootdemo4.config;


import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeFilterFunctions;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ProjectConfiguration {
    // The main purpose of this bean that it
    // helps us enter the auth credentials.
//    @Bean
//    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
//        return new BasicAuthRequestInterceptor("admin@eazyschool.com","admin");
//    }
//    @Bean
//    public RestTemplate restTemplate() {
//        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
//        return restTemplateBuilder.basicAuthentication("admin@eazyschool.com","admin").build();
//    }
//    @Bean
//    public WebClient webClient() {
//        return WebClient.builder().
//                filter(ExchangeFilterFunctions
//                        .basicAuthentication("admin@eazyschool.com","admin"))
//                .build();
//    }
}
