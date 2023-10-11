package br.com.math.todolist.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserRecordDto(@NotBlank String name, @NotNull @NotBlank String username, @NotBlank String password) {
}
