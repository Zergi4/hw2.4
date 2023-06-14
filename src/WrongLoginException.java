

public class WrongLoginException extends Exception{
    public WrongLoginException() {
        super("Недопустимый ввод");
    }

    public WrongLoginException(String message) {
        super(message);
    }
}
