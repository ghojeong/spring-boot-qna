package com.codessquad.qna.web.todo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TodoRepository {
    Map<Integer, Column> columns = new ConcurrentHashMap<>();

    TodoRepository() {
        columns.put(0, new Column(0, "해야할 일"));
        columns.put(1, new Column(1, "하고있는 일"));
        columns.put(2, new Column(2, "끝난 일"));
    }

    public TodoCard add(int columnId, TodoCard todoCard) {
        Column column = columns.get(columnId);
        return column.addCard(todoCard);
    }

    public void update(int columnId, TodoCard todoCard) {
        Column column = columns.get(columnId);
        column.updateCard(todoCard);
    }

    public void delete(int columnId, long todoCardId) {
        Column column = columns.get(columnId);
        column.deleteCard(todoCardId);
    }

    public Map<Integer, Column> get() {
        return columns;
    }
}
