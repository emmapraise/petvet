package com.emmapraise.petvet.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AttachDto {
    private long id;
    @Column(unique = true)
    private String name;
    @Column(unique = true)
    private String path;
    private String type;
    private long size;
}
