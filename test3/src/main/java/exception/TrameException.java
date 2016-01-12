package exception;

@SuppressWarnings("serial")
public class TrameException extends RuntimeException {
// code d'erreur

    private int code;

    public TrameException(int code) {
        super();
        this.code = code;
    }

    public TrameException(String message, int code) {
        super(message);
        this.code = code;
    }

    public TrameException(Throwable cause, int code) {
        super(cause);
        this.code = code;
    }

    public TrameException(String message, Throwable cause, int code) {
        super(message, cause);
        this.code = code;
    }
// getter et setter

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}