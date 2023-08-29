package com.example.datahandling.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder @Data
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue
    private Long id;

    private String content;

    private Integer timesAsked;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
}