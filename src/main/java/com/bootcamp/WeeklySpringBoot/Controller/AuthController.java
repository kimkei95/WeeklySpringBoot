package com.bootcamp.WeeklySpringBoot.Controller;

import com.bootcamp.WeeklySpringBoot.Service.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
    public class AuthController {
        public static final Logger LOG = LoggerFactory.getLogger(AuthController.class);
        private final TokenService tokenService;

        public AuthController(TokenService tokenService) {
            this.tokenService = tokenService;
        }
        @PostMapping("/token")
        public String token(Authentication authentication){
            LOG.debug("Token Requested for user '{}'", authentication.getName());
            String token = tokenService.generateToken(authentication);
            LOG.debug("Token granted {}", token);
            return token;
        }
    }
