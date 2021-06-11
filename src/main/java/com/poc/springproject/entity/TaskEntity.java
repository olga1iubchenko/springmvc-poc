package com.poc.springproject.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Locale;

@Entity
@Table
@Getter
@Setter
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Boolean completed;
    private Locale language;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public TaskEntity() {
    }

}
