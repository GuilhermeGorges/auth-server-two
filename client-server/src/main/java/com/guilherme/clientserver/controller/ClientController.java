package com.guilherme.clientserver.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class ClientController {

    @GetMapping("home")
    public Mono<String> home(
            @RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient client,
            @AuthenticationPrincipal OidcUser oidcUser
    ) {
        return Mono.just("""
                <h2>Acess Token: %s</h2>
                <h2> Refresh Token: %s</h2>
                <h2> ID Token: %s</h2>
                <h2> Claims: %s</h2>
                """.formatted(client.getAccessToken().getTokenValue(),
                null,
                oidcUser.getIdToken().getTokenValue(),
                oidcUser.getClaims()
                ));
    }
}
