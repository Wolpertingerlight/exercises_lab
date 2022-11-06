package Exercise_1;

public class Int {
    private int value;

    public Int(int i) {
        this.value = i;
    }

    public Int(){
        this(0);
    }

    public int getValue() {
        return this.value;
    }

    public void increment() {
        this.value++;
    }

    public void decrement() {
        this.value--;
    }

    public Int add(Int number) {
        return new Int(this.value + number.value);
    }

    public Int substruct(Int number){
        return new Int(this.value - number.value);
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
