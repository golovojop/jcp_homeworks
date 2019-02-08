package message;

public class Request extends Message {
    public Request(String message) {
        super.content = message;
        super.type = MessageType.REQUEST;
    }
}
