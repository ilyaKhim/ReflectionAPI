import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class TestClass {


    public static void start(Class c) throws InvocationTargetException, IllegalAccessException {


        Method[] methods = c.getDeclaredMethods();
        List<Method> list = new ArrayList<>();

        for (Method o : methods) {
            if (o.isAnnotationPresent(Test.class)) {
                int prio = o.getAnnotation(Test.class).priority();
                if (prio < 1 || prio > 10) throw new RuntimeException("Ошибка приоритета");
                list.add(o);
            }
        }

        list.sort(new Comparator<Method>() {
            @Override
            public int compare(Method o1, Method o2) {
                return o2.getAnnotation(Test.class).priority() - o1.getAnnotation(Test.class).priority();
            }
        });



        for (Method o : methods) {
            if (o.isAnnotationPresent(BeforeSuite.class)) {
                if (list.get(0).isAnnotationPresent(BeforeSuite.class))
                    throw new RuntimeException("BeforeSuite exception");
                list.add(0, o);
            }
            if (o.isAnnotationPresent(AfterSuite.class)){
                if (list.get(0).isAnnotationPresent(AfterSuite.class)){
                    throw new RuntimeException("AfterSuite exception");
                }
                    list.add(o);

            }
        }

        for(Method o: methods){

        }
        for( Method u: list){
            u.invoke(null);
        }



    }
    public static void main (String[]args) throws InvocationTargetException, IllegalAccessException {
        start(Main.class);
    }
}
