package com.sujal.DigitalJavaAssessment.model;

import java.io.Serializable;

public class JwtUser implements Serializable {

    private Long id;
    private String Username;
    private String role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
