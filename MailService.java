package task;

import task.Mail;

import java.util.*;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<Mail<T>> {

    private static class MyMap<K,V> extends HashMap<K,V>{
        @Override
        public V get(Object key) {
            if (super.get(key) == null) {
                return (V) Collections.<String>emptyList();
            }
            else return super.get(key);
        }
    }
    
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
