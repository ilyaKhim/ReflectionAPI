public class Main {

    @BeforeSuite
    public void init(){
        System.out.println("init");
    }

    @Test(priority = 8)
    public static void test1(){
        System.out.println("test1");
    }

    @Test(priority = 7)
    public static void test2(){
        System.out.println("test1");
    }

    @Test(priority = 6)
    public static void test3(){
        System.out.println("test1");
    }

    @Test(priority = 5)
    public static void test4(){
        System.out.println("test1");
    }

    @Test(priority = 4)
    public static void test5(){
        System.out.println("test1");
    }

    @Test(priority = 3)
    public static void test6(){
        System.out.println("test1");
    }

    @Test(priority = 2)
    public static void test7(){
        System.out.println("test1");
    }

    @Test(priority = 1)
    public static void test8(){
        System.out.println("test1");
    }

    @AfterSuite
    public void close(){
        System.out.println("closing");
    }


}