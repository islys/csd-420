

public class Generic<T> {
    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

    public static void main(String[] args) {
        Generic<String> stringBox = new Generic<>();
        stringBox.set("My class is holding a string!");
        System.out.println(stringBox.get()); 

        Generic<Integer> intBox = new Generic<>();
        intBox.set(1234213412);
        System.out.println(intBox.get()); 
    }
}
