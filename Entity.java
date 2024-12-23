import java.lang.reflect.Field;

public class Entity {
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName()).append(" [");

        Class<?> clazz = this.getClass();
        while (clazz != null) {
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                try {
                    sb.append(field.getName()).append("=").append(field.get(this)).append(", ");
                } catch (IllegalAccessException e) {
                    sb.append(field.getName()).append("=<inaccessible>, ");
                }
            }
            clazz = clazz.getSuperclass();
        }
        if (sb.length() > getClass().getSimpleName().length() + 2) {
            sb.setLength(sb.length() - 2);
        }
        sb.append("]");
        return sb.toString();
    }
}
