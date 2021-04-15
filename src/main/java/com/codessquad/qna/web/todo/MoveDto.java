package com.codessquad.qna.web.todo;

public class MoveDto {
    int beforeColumnId;
    int afterColumnId;
    TodoCard cardData;
    long targetCardId;

    public int getBeforeColumnId() {
        return beforeColumnId;
    }

    public void setBeforeColumnId(int beforeColumnId) {
        this.beforeColumnId = beforeColumnId;
    }

    public int getAfterColumnId() {
        return afterColumnId;
    }

    public void setAfterColumnId(int afterColumnId) {
        this.afterColumnId = afterColumnId;
    }

    public TodoCard getCardData() {
        return cardData;
    }

    public void setCardData(TodoCard cardData) {
        this.cardData = cardData;
    }

    public long getTargetCardId() {
        return targetCardId;
    }

    public void setTargetCardId(long targetCardId) {
        this.targetCardId = targetCardId;
    }
}
