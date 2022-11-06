package Exercise_3;

public class MyException extends RuntimeException {
    private final String text;
    public MyException(String string){
        this.text = string;
    }
    @Override
    public String getMessage() {
        return this.text;
    }
}
