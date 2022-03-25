package com.ewmw.client.http.requests;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

public class StoreLogsRequest {
    @NotBlank
    @Getter
    private String content;
}
