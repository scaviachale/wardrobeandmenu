package scaa.wardrobe.commons.exception;

public class CouldNotSendMessageException extends RuntimeException {

    public CouldNotSendMessageException() {
        super();
    }

    public CouldNotSendMessageException(String message) {
        super(message);
    }

    public CouldNotSendMessageException(String message, Throwable cause) {
        super(message, cause);
    }
}
