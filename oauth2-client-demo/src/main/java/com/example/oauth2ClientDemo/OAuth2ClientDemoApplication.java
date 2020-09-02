package com.example.oauth2ClientDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;

@SpringBootApplication
public class OAuth2ClientDemoApplication {

	@Bean
	@ConfigurationProperties("example.oauth2.okta")
	protected ClientCredentialsResourceDetails oktaOAuth2Details() {
		return new ClientCredentialsResourceDetails();
	}

	@Bean
	@ConfigurationProperties("example.oauth2.keycloak")
	protected ResourceOwnerPasswordResourceDetails keycloakOAuth2Details() {
		return new ResourceOwnerPasswordResourceDetails();
	}

	@Bean("oktaOAuth2RestTemplate")
	protected OAuth2RestTemplate oktaOAuth2RestTemplate() {
		return new OAuth2RestTemplate(oktaOAuth2Details());
	}

	@Bean("keycloakOAuth2RestTemplate")
	protected OAuth2RestTemplate keycloakOAuth2RestTemplate() {
		return new OAuth2RestTemplate(keycloakOAuth2Details());
	}

	public static void main(String[] args) {
		SpringApplication.run(OAuth2ClientDemoApplication.class, args);
	}

}
