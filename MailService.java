package task;

import task.Mail;

import java.util.*;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<Mail<T>> {

    Map<String, List<T>> mailBox = new HashMap<>();
    public Map<String, List<T>> getMailBox() {
        return mailBox;
    }

    @Override
    public void accept(Mail<T> tMail) {
        
        if (!this.mailBox.containsKey(tMail.getTo())) {
            List<T> value = new ArrayList<>();
            value.add(tMail.getContent());
            this.mailBox.put(tMail.getTo(), value);
        } else {
            List<T> value = this.mailBox.get(tMail.getTo());
            value.add(tMail.getContent());
            this.mailBox.put(tMail.getTo(), value);
        }
    }
}
