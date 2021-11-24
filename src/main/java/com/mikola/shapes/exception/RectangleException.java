package com.mikola.shapes.exception;

public class RectangleException extends Exception{
    public RectangleException(String format, String message) {
        super(message);
    }

    public RectangleException(String message,Throwable e) {
        super(message,e);
    }

    public RectangleException(String e) {
        super(e);
    }
}
