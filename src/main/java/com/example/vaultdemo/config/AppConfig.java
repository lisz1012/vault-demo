package com.example.vaultdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.core.VaultTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Configuration
public class AppConfig {
    @Bean
    public VaultTemplate vaultTemplate() {
        try {
            VaultEndpoint endpoint = VaultEndpoint.from(new URI("http://127.0.0.1:8200"));
            return new VaultTemplate(endpoint, new TokenAuthentication("hvs.T2uath1asfbVHv7sGaq8BrCZ"));
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

}
