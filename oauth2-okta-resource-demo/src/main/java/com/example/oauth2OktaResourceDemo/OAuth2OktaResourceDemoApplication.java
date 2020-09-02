package com.example.oauth2OktaResourceDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.expression.OAuth2MethodSecurityExpressionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
@EnableResourceServer
public class OAuth2OktaResourceDemoApplication {


	private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");

	public static void main(String[] args) {
		SpringApplication.run(OAuth2OktaResourceDemoApplication.class, args);
	}

	/**
	 * Allows for @PreAuthorize annotation processing.
	 */
	@EnableGlobalMethodSecurity(prePostEnabled = true)
	protected static class GlobalSecurityConfiguration extends GlobalMethodSecurityConfiguration {
		@Override
		protected MethodSecurityExpressionHandler createExpressionHandler() {
			return new OAuth2MethodSecurityExpressionHandler();
		}
	}

	@RestController
	public class MessageOfTheDayController {

		@GetMapping("/message")
		@PreAuthorize("#oauth2.hasScope('custom_service')")
		public String getMessageOfTheDay(Principal principal) throws InterruptedException {
			//Thread.sleep(3000);
			return "Okta at time: " + dtf.format(LocalDateTime.now());
		}
	}
}
