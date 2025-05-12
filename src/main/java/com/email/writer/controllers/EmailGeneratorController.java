package com.email.writer.controllers;

import com.email.writer.models.EmailRequest;
import com.email.writer.services.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/email")
public class EmailGeneratorController {

    private final EmailService emailService;

    public EmailGeneratorController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/generate")
    public ResponseEntity<String> generateEmail(@RequestBody EmailRequest emailRequest) {
        String response = emailService.generateEmailReply(emailRequest);
        return ResponseEntity.ok(response);
    }


}
