package com.meupetzinho.models.response;

public class JwtResponse {
    private String tokenJwt;
    private Long expiration;

    public JwtResponse(String tokenJwt, Long expiration) {
        this.tokenJwt = tokenJwt;
        this.expiration = expiration;
    }

    public String getTokenJwt() {
        return tokenJwt;
    }

    public void setTokenJwt(String tokenJwt) {
        this.tokenJwt = tokenJwt;
    }

    public Long getExpiration() {
        return expiration;
    }

    public void setExpiration(Long expiration) {
        this.expiration = expiration;
    }
}
