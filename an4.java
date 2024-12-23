@Validate(value = {String.class, Double.class})
public class an4 {
    private String name;
    private int age;

    public an4(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "an4{name='" + name + "', age=" + age + "}";
    }
}
