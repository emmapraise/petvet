package com.emmapraise.petvet.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "attachments")
public class Attach extends BaseEntity {
    @Column(unique = true)
    private String name;
    @Column(unique = true)
    private String path;
    private String type;
    @Lob
    private byte[] data;
}
