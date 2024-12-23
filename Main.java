import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            an1 obj = new an1();
            Class<?> clazz = obj.getClass();
            Method[] methods = clazz.getDeclaredMethods();
            boolean est = false;
            for (Method method : methods) {
                if (method.isAnnotationPresent(Invoke.class)) {
                    System.out.println(" ");
                    System.out.println("Найден метод с аннотацией @Invoke: " + method.getName());
                    method.invoke(obj);
                    est = true;
                }
            }
                    if (!est) {
                        System.out.println("Методов с аннотацией @Invoke нет");
                    }

            inspectClass(an23.class);

            inspectToString(an3.class);

            inspectValidate(an4.class);

            inspectTwo(an5.class);

            inspectCache(an6.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void inspectClass(Class<?> clazz) {
        if (clazz.isAnnotationPresent(Default.class)) {
            Default annotation = clazz.getAnnotation(Default.class);
            System.out.println("\nТип " + clazz.getSimpleName() + " аннотирован @Default с value: " + annotation.value());
        } else {
            System.out.println("\nТипов с аннотацией @Default нет");
        }
        boolean est2 = false;
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Default.class)) {
                Default annotation = field.getAnnotation(Default.class);
                System.out.println("Поле " + field.getName() + " в классе " + clazz.getSimpleName() + " аннотировано @Default с value: " + annotation.value());
                est2 = true;
            }
        }
        if (!est2) {
            System.out.println("В классе нет полей, аннотированных @Default.");
        }
    }

    private static void inspectToString(Class<?> clazz) {
        if (clazz.isAnnotationPresent(ToString.class)) {
            ToString annotation = clazz.getAnnotation(ToString.class);
            System.out.println("\nТип " + clazz.getSimpleName() + " аннотирован @ToString с value: " + annotation.value());
        } else {
            System.out.println("\nТипов с аннотацией @ToString нет");
        }
        boolean est3 = false;
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(ToString.class)) {
                ToString annotation = field.getAnnotation(ToString.class);
                System.out.println("Поле " + field.getName() + " в классе " + clazz.getSimpleName() + " аннотировано @ToString с value: " + annotation.value());
                est3 = true;
            }
        }
        if (!est3) {
            System.out.println("В классе нет полей, аннотированных @ToString.");
        }
    }
    private static void inspectValidate(Class<?> clazz) {
        if (clazz.isAnnotationPresent(Validate.class)) {
            Validate annotation = clazz.getAnnotation(Validate.class);
            System.out.println("\nТип " + clazz.getSimpleName() + " аннотирован @Validate с value: " + Arrays.toString(annotation.value()));
        } else {
            System.out.println("\nТипов с аннотацией @Validate нет");
        }
    }

    private static void inspectTwo(Class<?> clazz) {
        if (clazz.isAnnotationPresent(Two.class)) {
            Two annotation = clazz.getAnnotation(Two.class);
            System.out.println("\nТип " + clazz.getSimpleName() + " аннотирован @Two с first: " + annotation.first() + " и second: " + annotation.second());
        } else {
            System.out.println("\nТипов с аннотацией @Two нет");
        }
    }
    private static void inspectCache(Class<?> clazz) {
        if (clazz.isAnnotationPresent(Cache.class)) {
            Cache annotation = clazz.getAnnotation(Cache.class);
            System.out.println("\nТип " + clazz.getSimpleName() + " аннотирован @Cache с value: " + Arrays.toString(annotation.value()));
        } else {
            System.out.println("\nТипов с аннотацией @Cache нет");
        }
        A1 a1 = new A1();
        System.out.println(a1);

        B b = new B();
        System.out.println(b);
    }
}