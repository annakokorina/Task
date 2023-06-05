package task;

import task.Mail;

public class Salary implements Mail<Integer> {
    private String from;
    private String to;
    private Integer content;

    public Salary(String from, String to, Integer content) {
        this.from = from;
        this.to = to;
        this.content = content;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public Integer getContent() {
        return content;
    }
}
