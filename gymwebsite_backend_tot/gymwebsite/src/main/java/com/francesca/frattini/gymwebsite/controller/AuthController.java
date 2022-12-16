package com.francesca.frattini.gymwebsite.controller;

import com.francesca.frattini.gymwebsite.security.JwtUtils;

import com.francesca.frattini.gymwebsite.security.details.UserDetailsImpl;
import com.francesca.frattini.gymwebsite.security.login.LoginRequest;
import com.francesca.frattini.gymwebsite.security.login.LoginResponse;
import com.francesca.frattini.gymwebsite.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UtenteService us;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );


        authentication.getAuthorities();
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        /*List<String> roles = userDetails.getAuthorities().stream().map( jwtUtils::getAuthority )
                .collect(Collectors.toList());*/

        List<String> roles = null;
        return ResponseEntity.ok(
                new LoginResponse(jwt, (long) Math.toIntExact( userDetails.getId() ), userDetails.getUsername(),
                        (String) userDetails.getEmail(), null, userDetails.getExpirationTime()));
    }

}
