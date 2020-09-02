package com.example.oauth2ClientDemo.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Component;

@Component
public class AsyncService {

    //@Value("#{ @environment['example.baseUrl'] }")
    private static final String API_URL1="http://localhost:8081";
    private static final String API_URL2="http://localhost:8082";

    private final Logger log = LoggerFactory.getLogger(AsyncService.class);

    @Autowired
    @Qualifier("oktaOAuth2RestTemplate")
    OAuth2RestTemplate oktaOAuth2RestTemplate;

    @Autowired
    @Qualifier("keycloakOAuth2RestTemplate")
    OAuth2RestTemplate keycloakOAuth2RestTemplate;

    //@Async
    public void oktaRequest(){
        log.info("Okta access_token: {}", oktaOAuth2RestTemplate.getAccessToken());
        log.info(oktaOAuth2RestTemplate.getForObject(API_URL1 + "/message", String.class));
    }

    //@Async
    public void keylcloakRequest(){
        log.info("Keycloak access_token: {}", keycloakOAuth2RestTemplate.getAccessToken());
        log.info(keycloakOAuth2RestTemplate.getForObject(API_URL2 + "/message", String.class));
    }

    public void requestMessage(){
        oktaRequest();
        keylcloakRequest();
    }
}
