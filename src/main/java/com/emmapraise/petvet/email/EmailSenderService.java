package com.emmapraise.petvet.email;

public interface EmailSenderService {
    void send(String to, String email, String subject);
}
