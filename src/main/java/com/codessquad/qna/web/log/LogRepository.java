package com.codessquad.qna.web.log;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class LogRepository {
    private Map<Long, Log> logs = new ConcurrentHashMap<>();

    public Log add(Log log) {
        long id = logs.size();
        log.setId(id);
        logs.put(id, log);
        return log;
    }

    public List<Log> getLogs() {
        return logs.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public Log getLog(long id) {
        return logs.getOrDefault(id, new Log());
    }
}
