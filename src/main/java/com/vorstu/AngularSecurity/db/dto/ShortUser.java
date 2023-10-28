package com.vorstu.AngularSecurity.db.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShortUser {
    private Long id;
    private String name;
    private String surname;
}
