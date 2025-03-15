package com.pks.cricket_app.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class PlayerRequest {

    @NotNull
    @NotEmpty
    private  String name;

    @NotNull
    @NotEmpty
    private String role;


}
