package com.khebli.gestiondestockproject.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class AuthenticationRequest {
    String login;
    String passeword;

   public AuthenticationRequest(String login, String passeword) {
        this.login = login;
        this.passeword = passeword;
    }

    public AuthenticationRequest() {
    }
}
