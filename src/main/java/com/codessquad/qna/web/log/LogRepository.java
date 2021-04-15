package com.codessquad.qna.web.log;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class LogRepository {
    private Map<Integer, Log> logs = new ConcurrentHashMap<>();

    public Log add(Log log) {
        int questionId = logs.size();
        log.setId(questionId);
        logs.put(questionId, log);
        return log;
    }

    public List<Log> getLogs() {
        return logs.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public Log getLog(int id) {
        return logs.getOrDefault(id, new Log());
    }
}
