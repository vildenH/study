package src.String;


//剑指OFFER替换空格
public class ReplaceSpace {

    public String replaceSpace(StringBuffer str) {
        char[] strArr = str.toString().toCharArray();
        int blankCount = 0;
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i] == ' ') {
                blankCount++;
            }
        }

        char[] strNewArr = new char[str.length() + blankCount * 2];
        int newIndex = strNewArr.length - 1;
        for (int i = strArr.length - 1; i >= 0; i--) {
            if (strArr[i] != ' ') {
                strNewArr[newIndex] = strArr[i];
                newIndex--;
            } else {
                strNewArr[newIndex--] = '0';
                strNewArr[newIndex--] = '2';
                strNewArr[newIndex--] = '%';
            }

        }
        return new String(strNewArr);

    }

}
