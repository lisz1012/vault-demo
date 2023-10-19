package com.example.vaultdemo.config;

public class MySecretWrapper {
    public MySecret getData() {
        return data;
    }

    public void setData(MySecret data) {
        this.data = data;
    }

    private MySecret data;
    
    // getters and setters
}