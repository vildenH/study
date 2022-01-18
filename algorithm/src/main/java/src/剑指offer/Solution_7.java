package src.剑指offer;

public class Solution_7 {

  //0 1 1 2 3 5
  public int Fibonacci(int n) {
    int n0 = 0;
    int n1 = 1;
    if (n == 0) {
      return n0;
    } else if (n == 1) {
      return n1;
    }
    int lastN1 = n0;
    int lastN2 = n1;
    int result = 0;
    for (int i = 1; i < n; i++) {
      result = lastN1 + lastN2;
      lastN1 = lastN2;
      lastN2 = result;
    }
    return result;
  }
}
