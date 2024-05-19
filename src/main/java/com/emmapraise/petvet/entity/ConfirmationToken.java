package com.emmapraise.petvet.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;


@Getter
@Setter
@Entity(name = "tokens")
@NoArgsConstructor
public class ConfirmationToken extends BaseEntity {
    @Column(nullable = false)
    private String token;
    private LocalDateTime expiredAt;
    private LocalDateTime confirmedAt;

    @ManyToOne
    @JoinColumn(name = "app_user_id")
    private AppUser appUser;

    public ConfirmationToken(String token,
                             LocalDateTime expiredAt,
                             AppUser appUser) {
        this.token = token;
        this.expiredAt = expiredAt;
        this.appUser = appUser;
    }
}
