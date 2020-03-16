package com.erofeev.demo.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PresidentDTO implements Serializable {
    private static final long serialVersionUID = 5517244812959569958L;
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
}
