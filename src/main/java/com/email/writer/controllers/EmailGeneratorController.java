package com.email.writer.controllers;

import com.email.writer.models.EmailRequest;
import com.email.writer.response.ApiResponse;
import com.email.writer.services.EmailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestController
@RequestMapping("/api/email")
public class EmailGeneratorController {

    private final EmailService emailService;

    public EmailGeneratorController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/generate")
    public ResponseEntity<ApiResponse> generateEmail(@RequestBody EmailRequest emailRequest) {
        try {
            String response = emailService.generateEmailReply(emailRequest);
            return ResponseEntity.ok(new ApiResponse("Success",response));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(),null));
        }
    }


}
