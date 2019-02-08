package message;

public class Response extends Message {
    public Response(String message) {
        super.content = message;
        super.type = MessageType.RESPONSE;
    }
}
