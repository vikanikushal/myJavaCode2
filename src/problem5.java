/*
Good morning! Here's your coding interview problem for today.

This problem was asked by Jane Street.

cons(a, b) constructs a pair, and car(pair)
cdr(pair) returns the first and last element of that pair. For example,
car(cons(3, 4)) returns 3, and cdr(cons(3, 4)) returns 4.
 */

public class problem5 {

    public static void main(String[] args) {

        System.out.println(car(cons(3,4)));
        System.out.println(cdr(cons(5,6)));
    }
    private static pair cons(int a,int b)
    {
        return (new pair(a,b));
    }
    private static int car(pair p)
    {
        return p.get_a();
    }
    private static  int cdr(pair p)
    {
        return p.get_b();

    }


    private static class pair{
        int a;
        int b;

        pair(int a, int b)
        {
            this.a=a;
            this.b=b;
        }
        public int get_a()
        {
            return this.a;
        }
        public int get_b()
        {
            return this.b;
        }
    }

}
