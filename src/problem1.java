/*Good morning! Here's your coding interview problem for today.

        This problem was recently asked by Google.

        Given a list of numbers and a number k, return whether any two numbers from the list add up to k.

        For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

        Bonus: Can you do this in one pass?*/


import java.util.HashSet;
import java.util.Set;

public class problem1 {

    public static void main(String[] args) {

        int[] arr = {10, 15, 3 ,7};
        System.out.println(solution(arr,17));

    }

    public static boolean solution(int[] arr, int k)
    {
        if(arr == null)
            return false;
        if(arr.length < 2)
            return false;

        Set<Integer> temp = new HashSet<>();

        for(int val : arr)
        {
            if(temp.contains(val))
                return true;
            temp.add(k-val);
        }

        return false;
    }

}
