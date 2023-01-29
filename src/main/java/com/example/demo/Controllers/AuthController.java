package com.example.demo.Controllers;

import com.example.demo.Models.Token;
import com.example.demo.Models.User;
import com.example.demo.Payloads.Requests.AuthLoginRequest;
import com.example.demo.Payloads.Requests.AuthRegistrationRequest;
import com.example.demo.Payloads.Responses.AuthResponse;
import com.example.demo.Payloads.Responses.MessageResponse;
import com.example.demo.Repositories.TokenRepository;
import com.example.demo.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(path = {"api/v1/auth"})
public class AuthController {

    @Autowired(required = false)
    private UserRepository userRepository;

    @Autowired(required = false)
    private TokenRepository tokenRepository;

    @PostMapping("/login")
    private MessageResponse login (@RequestBody AuthLoginRequest authLoginRequest) {
        try {
            if (userRepository.findByLogin(authLoginRequest.getLogin()) == null) return new MessageResponse("User not found", 400);

            User user = userRepository.findByLogin(authLoginRequest.getLogin());
            if (!authLoginRequest.getPasswordHASH().equals(user.getPasswordHASH())) return new MessageResponse("Not correct password", 400);

            if (tokenRepository.findByUid(user.getUid()) != null) tokenRepository.delete(tokenRepository.findByUid(user.getUid()));

            Token token = new Token(user.getUid());
            tokenRepository.save(token);

            return new MessageResponse("success", 200, new AuthResponse(user, token));

        } catch (Exception e) { return new MessageResponse("Some error", 400); }
    }

    @PostMapping("/registration")
    private MessageResponse registration (@RequestBody AuthRegistrationRequest authRegistrationRequest) {
        try {
            if (userRepository.findByLogin(authRegistrationRequest.getLogin()) != null) return new MessageResponse("Account already exist", 400);

            User user = new User(authRegistrationRequest);
            userRepository.save(user);

//            Token token = new Token(user.getUid());
//            tokenRepository.save(token);

            return new MessageResponse("success", 200);

        } catch (Exception e) { return new MessageResponse("Some error", 400); }
    }
}
