package com.example.dstudyserver.domain.admin.controller.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EntryRequest {
    @NotBlank
    private boolean isAccept;
}
