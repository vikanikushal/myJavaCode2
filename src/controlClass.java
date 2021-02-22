public class controlClass {

    /*public static void printArray(int[] arr)
    {
        for(int a:arr)
            System.out.println(a);
    }
    public static void printArray(double[] arr)
    {
        for(double a:arr)
            System.out.println(a);
    }*/

    public static <E> void printArray(E[] arr)
    {
        for(E a:arr)
            System.out.println(a);
    }
}
