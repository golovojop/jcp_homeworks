package message;

import java.io.Serializable;

public abstract class Message implements Serializable {
    MessageType type;
    String content;

    public void setContent(String content) {
        this.content = content;
    }

    public MessageType getType() {
        return type;
    }

    public String getContent() {
        return content;
    }
}
