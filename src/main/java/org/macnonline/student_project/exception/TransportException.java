package org.macnonline.student_project.exception;
// problem with sky
public class TransportException extends Exception{
    public TransportException() {
        super();
    }

    public TransportException(String message) {
        super(message);

    }

    public TransportException(String message, Throwable cause) {
        super(message, cause);
    }
}
