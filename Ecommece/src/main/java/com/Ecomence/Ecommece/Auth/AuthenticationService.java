package com.Ecomence.Ecommece.Auth;

import com.Ecomence.Ecommece.Entities.User;
import com.Ecomence.Ecommece.Enum.Role;
import com.Ecomence.Ecommece.SpringSecurity.JwtService;
import com.Ecomence.Ecommece.Repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public AuthenticationResponse registerUser( RegistrationRequest registrationRequest){
        User user = new User();
        user.setFirstname(registrationRequest.getFirstname());
        user.setLastname(registrationRequest.getLastname());
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
        user.setEmail(registrationRequest.getEmail());
        this.userRepository.save(user);
        String token = this.jwtService.generateToken(user);
        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        authenticationResponse.setFirstname(registrationRequest.getFirstname());
        authenticationResponse.setLastname(registrationRequest.getLastname());
        authenticationResponse.setEmail(registrationRequest.getEmail());
        authenticationResponse.setRole(Role.USER.toString());
        authenticationResponse.setToken(token);
        return authenticationResponse;

    }
    public AuthenticationResponse loginUser(AuthenticateRequest authenticateRequest){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticateRequest.getEmail(),
                authenticateRequest.getPassword()
        ));
        User user = this.userRepository.findByEmail(authenticateRequest.getEmail()).orElseThrow(()-> new UsernameNotFoundException("User NotFound"));
        String token = this.jwtService.generateToken(user);
        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        authenticationResponse.setFirstname(user.getFirstname());
        authenticationResponse.setLastname(user.getLastname());
        authenticationResponse.setRole(user.getRole().toString());
        authenticationResponse.setToken(token);
        authenticationResponse.setEmail(user.getEmail());
        return authenticationResponse;
    }
    @PostConstruct
    public void RegisterAdmin(){

        if(!this.userRepository.existsByRole(Role.ADMIN)){
            User user = new User();
            user.setEmail("ato@gmail.com");
            user.setFirstname("Isaac");
            user.setLastname("Asante");
            user.setPassword(passwordEncoder.encode("ato"));
            user.setRole(Role.ADMIN);
            this.userRepository.save(user);
        }

    }
}
