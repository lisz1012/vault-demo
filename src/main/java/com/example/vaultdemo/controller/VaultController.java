package com.example.vaultdemo.controller;

import com.example.vaultdemo.config.MySecret;
import com.example.vaultdemo.config.MySecretWrapper;
import com.example.vaultdemo.config.MyUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponse;
import org.springframework.vault.support.VaultResponseSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@Configuration
@RestController
public class VaultController {
//    @Value("${password}")
//    private String password;

    @Autowired
    private VaultTemplate vaultTemplate;

    @GetMapping("password")
    public String getPassword() {
        // 注意: 这里先要在 vault 中添加username 和 password: `vault kv put secret/data/vault-demo/dev username=u1 password=456`, 检验: `vault kv get secret/data/vault-demo/dev`
        VaultResponseSupport<MySecretWrapper> response = vaultTemplate.read("secret/data/data/vault-demo/dev", MySecretWrapper.class);
        String username = response.getData().getData().getUsername();
        String password = response.getData().getData().getPassword();
        String url = response.getData().getData().getUrl();
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("Url: " + url);
        VaultResponseSupport<MySecretWrapper> response2 = vaultTemplate.read("secret/data/data/vault-demo", MySecretWrapper.class);
        String url2 = response2.getData().getData().getUrl();
        System.out.println("URL2: " + url2);
        VaultResponseSupport<MySecretWrapper> response3 = vaultTemplate.read("secret/data/vault-demo", MySecretWrapper.class);
        String url3 = response3.getData().getData().getUrl();
        System.out.println("URL3: " + url3);
        return password;
    }
}
