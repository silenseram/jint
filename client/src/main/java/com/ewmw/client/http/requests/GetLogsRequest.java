package com.ewmw.client.http.requests;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Date;

public class GetLogsRequest {
    @Getter
    @NotBlank
    private LocalDateTime from;

    @Getter
    @NotBlank
    private LocalDateTime to;
}
