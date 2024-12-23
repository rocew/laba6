import java.lang.reflect.Field;

public class Entity1 {
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName()).append(" [");
        boolean classAnnotatedNo = false;
        ToString classAnnotation = this.getClass().getAnnotation(ToString.class);
        if (classAnnotation != null && classAnnotation.value() == ToString.Value.NO) {
            classAnnotatedNo = true;
        }
        Class<?> clazz = this.getClass();
        while (clazz != null) {
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                ToString fieldAnnotation = field.getAnnotation(ToString.class);
                boolean includeField = true;
                if (classAnnotatedNo) {
                    includeField = fieldAnnotation != null && fieldAnnotation.value() == ToString.Value.YES;
                } else {
                    if (fieldAnnotation != null && fieldAnnotation.value() == ToString.Value.NO) {
                        includeField = false;
                    }
                }

                if (includeField) {
                    try {
                        sb.append(field.getName()).append("=").append(field.get(this)).append(", ");
                    } catch (IllegalAccessException e) {
                        sb.append(field.getName()).append("=<inaccessible>, ");
                    }
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

