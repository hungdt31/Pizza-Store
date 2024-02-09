class Prototype implements Cloneable {
    private String value;

    public Prototype(String value) {
        this.value = value;
    }

    public Prototype clone() {
        try {
            return (Prototype) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getValue() {
        return value;
    }
}

public class PrototypeExample {
    public static void main(String[] args) {
        Prototype original = new Prototype("Original Value");
        Prototype clone1 = original.clone();
        Prototype clone2 = original.clone();

        System.out.println(clone1.getValue()); // Kết quả sẽ là "Original Value"
        System.out.println(clone2.getValue()); // Kết quả sẽ là "Original Value"
    }
}
