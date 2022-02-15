package src.alg;

import src.test.Solution;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class 计算器 {
    public static void main(String[] args) {
        //System.out.println(new Solution().splitToken("1+2+ 4"));

        计算器 solution = new 计算器();
        System.out.println(solution.calToken(solution.splitToken("1 2 3  * +")));
        System.out.println(solution.tran(solution.splitToken("(1 +2)+ (3 * 5)")));
        System.out.println(solution.calToken(solution.tran(solution.splitToken("(1 +2)+ (3 * 5)"))));
    }

    //获取优先级
    int getOpt(char o) {
        if (o == '+') {
            return 1;
        } else if (o == '-') {
            return 1;
        } else if (o == '*') {
            return 2;
        } else if (o == '/') {
            return 2;
        } else if (o == '(') {
            return 0;
        }
        return -1;
    }

    //中缀转逆波兰
    public ArrayList<Object> tran(ArrayList<Object> token) {
        ArrayList result = new ArrayList();
        ArrayDeque<Character> stk = new ArrayDeque();
        boolean p = true;
        for (int i = 0; i < token.size(); i++) {
            Object o = token.get(i);
            if (o instanceof Integer) {
                result.add(o);
                continue;
            }
            Character c = (Character) o;
            if (c == ')') {
                while (!stk.isEmpty() && stk.peek() != '(') {
                    result.add(stk.pop());
                }
                stk.pop();
            } else if (c == '(') {
                stk.push(c);
            } else {
                if (c == '-') {
                    if (i == 0 || (token.get(i - 1) instanceof Character && (Character) token.get(i - 1) == '(')) {
                        result.add(0);
                    }
                }

                while (!stk.isEmpty() && getOpt(stk.peek()) >= getOpt(c)) {
                    result.add(stk.pop());
                }
                stk.push(c);
            }
        }
        while (!stk.isEmpty()) {
            result.add(stk.pop());
        }
        return result;
    }

    public Integer calToken(ArrayList token) {
        ArrayDeque<Object> stk = new ArrayDeque();
        for (Object o : token) {
            if (o instanceof Character) {
                Character c = (Character) o;
                Integer b = (Integer) stk.pop();
                Integer a = (Integer) stk.pop();
                if (c == '+') {
                    stk.push(a + b);
                } else if (c == '-') {

                    stk.push(a - b);
                } else if (c == '*') {
                    stk.push(a * b);
                } else if (c == '/') {
                    stk.push(a / b);
                }
            } else {
                stk.push(o);
            }
        }

        return (Integer) stk.pop();
    }


    public ArrayList<Object> splitToken(String str) {
        char[] chars = str.toCharArray();
        ArrayList<Object> token = new ArrayList();
        int num = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                continue;

            } else if (chars[i] >= '0' && chars[i] <= '9') {
                num = num * 10 + (chars[i] - '0');
                //如果是末尾或者后面是个字符，说明这个数字结束了
                if (i + 1 < chars.length && !(chars[i + 1] >= '0' && chars[i + 1] <= '9')) {
                    token.add(num);
                    num = 0;
                } else if (i + 1 == chars.length) {
                    token.add(num);
                    num = 0;
                }
            } else {
                token.add(chars[i]);
            }
        }

        return token;
    }

}
