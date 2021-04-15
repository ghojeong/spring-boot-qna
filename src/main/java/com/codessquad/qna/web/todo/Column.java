package com.codessquad.qna.web.todo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Column {
    long id;
    String title;
    final Map<Long, TodoCard> todoCards = new ConcurrentHashMap<>();

    public Column(long id, String title) {
        this.id = id;
        this.title = title;
    }

    public TodoCard addCard(TodoCard todoCard) {
        todoCards.put(todoCard.getId(), todoCard);
        return todoCard;
    }

    public void updateCard(TodoCard todoCard) {
        todoCards.put(todoCard.getId(), todoCard);
    }

    public void deleteCard(long todoCardId) {
        todoCards.remove(todoCardId);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Map<Long, TodoCard> getTodoCards() {
        return todoCards;
    }
}
