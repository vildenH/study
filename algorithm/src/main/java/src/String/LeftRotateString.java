package src.String;

public class LeftRotateString {

    public String ReverseSentence(String str) {

        if (str == null || str.isEmpty()) {
            return str;
        }
        if (str.equals(" ")) {
            return " ";
        }



        String reverseStr = ReverseString(str.toCharArray());
        String[] array = reverseStr.split(" ");
        StringBuffer ans = new StringBuffer();
        for (int i = 0; i < array.length; i++) {
            array[i] = ReverseString(array[i].toCharArray());
            ans.append(array[i]);
            if (i != (array.length - 1)) {
                ans.append(" ");
            }
        }

        return ans.toString();


    }


    public String ReverseString(char[] str) {
        for (int i = 0; i < str.length / 2; i++) {
            char temp = str[i];
            str[i] = str[str.length - 1 - i];
            str[str.length - 1 - i] = temp;
        }
        return new String(str);
    }

    public static void main(String[] args) {
        String str = "I am a student.";
        str = " ";
        System.out.println(new LeftRotateString().ReverseSentence(str));
    }

    public String leftRotateString(String str, int n) {

        if (str == null || str.isEmpty()) {
            return str;
        }
        if (n > 0 && n < str.length()) {
            String a = str.substring(0, n);
            String b = str.substring(n, str.length());
            a = ReverseString(a.toCharArray());
            b = ReverseString(b.toCharArray());
            return ReverseString((a + b).toCharArray());
        }

        return str;

    }
}
