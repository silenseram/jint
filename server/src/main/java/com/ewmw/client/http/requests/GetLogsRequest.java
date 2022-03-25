package com.ewmw.client.http.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class GetLogsRequest {
    @Getter
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate from;

    @Getter
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate to;
}
