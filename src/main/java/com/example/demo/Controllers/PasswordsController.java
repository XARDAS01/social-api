package com.example.demo.Controllers;

import com.example.demo.Models.Password;
import com.example.demo.Payloads.Requests.PasswordAddRequest;
import com.example.demo.Payloads.Responses.MessageResponse;
import com.example.demo.Repositories.PasswordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(path = {"api/v1/passwords"})
public class PasswordsController {

    @Autowired(required = false)
    private PasswordRepository passwordRepository;

    @GetMapping("/getAllByUser")
    private MessageResponse getAllByUser (@RequestParam (value = "authorUID") String authorUID) {
        try {
            ArrayList<Password> passwords = passwordRepository.findAllByAuthorUID(authorUID);

            return new MessageResponse("success", 200, passwords);
        } catch (Exception e) { return new MessageResponse("some error", 200); }
    }

    @GetMapping("/deleteServiceByID")
    private MessageResponse deleteServiceByID (@RequestParam (value = "serviceId") Long serviceId) {
        try {
            passwordRepository.deleteById(serviceId);

            return new MessageResponse("success", 200);

        } catch (Exception e) { return new MessageResponse("some error", 400); }
    }

    @PostMapping("/addNew")
    private MessageResponse addNewPassword (@RequestBody PasswordAddRequest passwordAddRequest) {
        try {
            passwordRepository.save(new Password(passwordAddRequest));

            return new MessageResponse("success", 200);

        } catch (Exception e) { return new MessageResponse("some error", 400); }
    }
}
