package homework.february.two.endlessarray;

class BoundOfIndexExceptions extends RuntimeException {

    public BoundOfIndexExceptions(String message) {
        super(message);
    }

    public BoundOfIndexExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public BoundOfIndexExceptions(Throwable cause) {
        super(cause);
    }

    public BoundOfIndexExceptions(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
