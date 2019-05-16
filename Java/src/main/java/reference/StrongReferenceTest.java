package reference;

/**
 * @author wh
 * @date 2019-05-15
 */
public class StrongReferenceTest {
    public static int M = 1024 * 1024;

    public static void printlnMemory(String tag) {
        Runtime runtime = Runtime.getRuntime();
        int M = StrongReferenceTest.M;
        System.out.println("\n" + tag + ":");
        System.out.println(runtime.freeMemory() / M + "M(free)/" + runtime.totalMemory() / M + "M(total)");
    }

    public static void main(String[] args) {
        printlnMemory("1.原可用内存和总内存");

        //实例化10M的数组并与strongReference建立强引用
        byte[] strongReference = new byte[10 * M];
        printlnMemory("2.实例化10M的数组,并建立强引用");
        System.out.println("strongReference : " + strongReference);

        System.gc();
        printlnMemory("3.GC后");
        System.out.println("strongReference : " + strongReference);

        //strongReference = null;后,强引用断开了
        strongReference = null;
        printlnMemory("4.强引用断开后");
        System.out.println("strongReference : " + strongReference);

        System.gc();
        printlnMemory("5.GC后");
        System.out.println("strongReference : " + strongReference);
    }
}


