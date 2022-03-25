package com.ewmw.client.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class Log {
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String content;

    @Getter @Setter
    @JsonProperty("createdAt")
    private String created_at;
}
