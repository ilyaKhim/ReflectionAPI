import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestClass {
    public static void start(Class test) throws NoSuchMethodException {
        test = Main.class;

        Method m = Main.class.getDeclaredMethod("printWelcome", String.class);
        m.setAccessible(true);
        Test test1 = m.getAnnotation(Test.class);
        System.out.println(test1.value());
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        start(Main.class);

    }

}
