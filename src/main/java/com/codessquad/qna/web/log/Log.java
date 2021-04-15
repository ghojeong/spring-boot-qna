package com.codessquad.qna.web.log;

public class Log {
    long id;
    String action;
    String columnTitle;
    String itemTitle;
    long date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getColumnTitle() {
        return columnTitle;
    }

    public void setColumnTitle(String columnTitle) {
        this.columnTitle = columnTitle;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", action='" + action + '\'' +
                ", columnTitle='" + columnTitle + '\'' +
                ", itemTitle='" + itemTitle + '\'' +
                ", date=" + date +
                '}';
    }
}
