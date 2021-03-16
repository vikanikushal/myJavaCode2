/*
Good morning! Here's your coding interview problem for today.

This problem was asked by Facebook.

Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.

For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.

You can assume that the messages are decodable. For example, '001' is not allowed.
 */

public class problem7 {

    public static void main(String[] args) {
        String encodeString = "1210";
        System.out.println(numDecoding(encodeString));
    }


    private static int numDecoding(String encodedString)
    {
        if(encodedString == null || encodedString.length()==0)
            return 0;
        else if(encodedString.charAt(0) == '0')
            return 0;
        else if(encodedString.length() == 1)
            return 1;
        else {
            // compute the 2 initial values of the array (intuitively)
            int[] decodingUpToChar = new int[encodedString.length()];
            if (encodedString.charAt(0) == '0') {
                return 0;
            } else {
                decodingUpToChar[0] = 1;
            }
            if (encodedString.charAt(1) == '0') {
                if(encodedString.charAt(0) == '1' || encodedString.charAt(0) == '2') {
                    decodingUpToChar[1] = 1;
                } else {
                    decodingUpToChar[1] = 0;
                }
            } else if (Integer.parseInt(encodedString.substring(0, 2)) > 26) {
                decodingUpToChar[1] = 1;
            } else {
                decodingUpToChar[1] = 2;
            }

            for (int i = 2; i < encodedString.length(); i++) {
                if (encodedString.charAt(i) != '0') {
                    decodingUpToChar[i] += decodingUpToChar[i-1];
                }
                int twoDigitValue = Integer.parseInt(encodedString.substring(i - 1, i + 1));
                if (twoDigitValue <= 26 && twoDigitValue >= 10) {
                    decodingUpToChar[i] += decodingUpToChar[i-2];
                }
            }
            return decodingUpToChar[encodedString.length() - 1];
        }
    }

}
