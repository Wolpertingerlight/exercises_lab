package Exercise_1;

public class Int {
    private int value;
    private int subValue;
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
    public Int multiply(Int number){
        if (this.value == 0 || number.value == 0) return new Int();
        while (this.subValue != this.value * number.value){
            if (this.value < 0 && number.value < 0){
                this.subValue++;
            }
            if (this.value < 0 && number.value > 0){
                this.subValue--;
            }
            if (this.value > 0 && number.value < 0){
                this.subValue--;
            }
            if (this.value > 0 && number.value > 0){
                this.subValue++;
            }
        }
        return new Int(subValue);
    }
    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
