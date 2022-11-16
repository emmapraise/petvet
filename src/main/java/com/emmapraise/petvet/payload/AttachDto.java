package com.emmapraise.petvet.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AttachDto {
    private long id;
    private String name;
    private String path;
    private String type;
    private long size;
}
