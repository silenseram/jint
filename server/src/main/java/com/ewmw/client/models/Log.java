package com.ewmw.client.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "log", schema = "log")
public class Log {
    @Id
    @Column(name = "id", nullable = false)
    @Getter @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Getter @Setter
    private String content;

    @Getter @Setter
    @Column(name = "created_at")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate createdAt;
}
