package tech.myic.day.one;

public class CustomException extends Exception {

    public CustomException() {
    }

    public CustomException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

}
