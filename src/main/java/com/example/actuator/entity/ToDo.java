package com.example.actuator.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Data
public class ToDo {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid" , strategy = "uuid")
    private String id;

    @NotNull
    @NotBlank
    private String description;

    @Column(insertable = true, updatable = false)
    private LocalDateTime created;
    private LocalDateTime updated;
    private boolean completed;
    public ToDo(){}
    public ToDo(String description){
        this.description = description;
    }
    @PrePersist
    void onCreate(){
        this.setCreated(LocalDateTime.now());
        this.setUpdated(LocalDateTime.now());
    }
    @PreUpdate
    void onUpdate(){
        this.setUpdated(LocalDateTime.now());
    }
}
