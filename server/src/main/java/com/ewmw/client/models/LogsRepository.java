package com.ewmw.client.models;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface LogsRepository extends CrudRepository<Log, Long> {
    @Query("SELECT l FROM Log l WHERE l.createdAt >= :dateFrom AND l.createdAt <= :dateTo")
    List<Log> getLogs(LocalDate dateFrom, LocalDate dateTo);
}
