@Cache(value = {"это первый", "это второй"})
public class an6 {
    private String name;
    private int age;

    public an6(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "an6{name='" + name + "', age=" + age + "}";
    }
}
