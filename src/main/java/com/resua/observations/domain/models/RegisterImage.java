package com.resua.observations.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterImage {
    private Long id;
    private String imageUrl;
    private Integer imageOrder;
    private LocalDateTime createdAt;
}

