package com.ewmw.client.services.logs;

import com.ewmw.client.models.Log;
import com.ewmw.client.models.LogsRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@NoArgsConstructor
public class DatabaseLogsService implements LogsService {

    @Autowired
    LogsRepository logsRepository;

    @Override
    public List<Log> getLogs(LocalDate from, LocalDate to) {
        if (from == null)
            from = LocalDate.now().minusDays(1);

        if (to == null)
            to = LocalDate.now();

        return logsRepository.getLogs(from, to);
    }

    @Override
    public boolean saveLog(String content) {
        Log log = new Log();

        log.setContent(content);
        log.setCreatedAt(LocalDate.now());

        logsRepository.save(log);

        return true;
    }
}
