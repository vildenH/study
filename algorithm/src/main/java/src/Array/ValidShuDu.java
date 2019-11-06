package src.Array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wh
 * @date 2019/11/6
 */
public class ValidShuDu {
  public boolean isValidSudoku(char[][] board) {
    // 一次遍历搞掂
    // check hang
    for (int i = 0; i < 9; i++) {
      Set row = new HashSet<>();
      Set col = new HashSet<>();
      Set block = new HashSet<>();

      for (int j = 0; j < 9; j++) {
        // 这是行
        if (board[i][j] != '.') {
          if (row.add(board[i][j]) == false) {
            return false;
          }
        }
        // 这是列
        if (board[j][i] != '.') {
          if (col.add(board[j][i]) == false) {
            return false;
          }
        }
        // 这是块
        int rowIndex = j / 3;
        int colIndex = j % 3;
        int realRow = rowIndex + (3 * (i / 3));
        int realCol = colIndex + (3 * (i % 3));
        if (block.add(board[realRow][realCol]) == false) {
          return false;
        }
      }
    }
    return true;

  }

}
