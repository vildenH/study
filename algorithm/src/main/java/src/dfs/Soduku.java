package src.dfs;

public class Soduku {
    public static void main(String[] args) {
        Board board = new Board(new int[][]{
                new int[]{5, 0, 0, 0, 4, 0, 0, 9, 6},
                new int[]{4, 3, 0, 5, 6, 0, 8, 2, 0},
                new int[]{0, 6, 9, 2, 0, 0, 4, 0, 0},
                new int[]{0, 0, 0, 0, 0, 0, 7, 4, 0},
                new int[]{2, 4, 0, 0, 0, 0, 0, 6, 8},
                new int[]{0, 8, 3, 0, 0, 0, 0, 0, 0},
                new int[]{0, 0, 2, 0, 0, 3, 6, 7, 0},
                new int[]{0, 7, 5, 0, 8, 6, 0, 1, 9},
                new int[]{6, 9, 0, 0, 2, 0, 0, 0, 3},
        });
        //Board board = new Board(new int[][]{
        //        new int[]{4, 3, 0, 0, 5, 7, 0, 0, 0},
        //        new int[]{0, 0, 0, 0, 0, 0, 0, 0, 5},
        //        new int[]{6, 0, 0, 0, 0, 0, 9, 1, 0},
        //        new int[]{0, 0, 0, 0, 8, 0, 0, 5, 0},
        //        new int[]{0, 9, 0, 3, 0, 5, 0, 7, 0},
        //        new int[]{0, 2, 0, 0, 9, 0, 0, 0, 0},
        //        new int[]{0, 4, 6, 0, 0, 0, 0, 0, 7},
        //        new int[]{3, 0, 0, 0, 7, 0, 0, 0, 0},
        //        new int[]{0, 0, 0, 5, 1, 0, 0, 9, 3},
        //});
        board.printContent();

        board.dfs(0, 0);
    }
}

class Board {
    Piece[][] content;

    int[][] rowUsed;
    int[][] colUsed;
    int[][] blockedUsed;

    //穷举的次数
    private static int calCount = 0;

    public Board(int[][] in) {
        content = new Piece[in.length][in[0].length];
        rowUsed = new int[9][9];
        colUsed = new int[9][9];
        blockedUsed = new int[9][9];

        for (int i = 0; i < in.length; i++) {
            for (int j = 0; j < in[0].length; j++) {
                content[i][j] = new Piece();
                if (in[i][j] != 0) {
                    content[i][j].isFixed = true;
                    content[i][j].num = in[i][j];

                    rowUsed[i][in[i][j] - 1] = 1;
                    colUsed[j][in[i][j] - 1] = 1;
                    blockedUsed[(i / 3) * 3 + j / 3][in[i][j] - 1] = 1;
                }
            }
        }
    }

    private boolean isValid(int row, int col, int num) {
        //行
        if (rowUsed[row][num - 1] == 1) {
            return false;
        }
        //列
        if (colUsed[col][num - 1] == 1) {
            return false;
        }
        //块
        if (blockedUsed[(row / 3) * 3 + col / 3][num - 1] == 1) {
            return false;
        }
        return true;
    }

    public void printContent() {
        for (int i = 0; i < content.length; i++) {
            for (int j = 0; j < content[0].length; j++) {
                System.out.print(content[i][j].num);
                if (j == content[0].length - 1) {
                    System.out.println();
                } else {
                    System.out.print(" ");
                }
            }
        }
        System.out.println();
    }

    public void dfs(int row, int col) {
        calCount++;
        if (row == 9) {
            System.out.println("计算次数:" + calCount);
            printContent();
            return;
        }
        if (content[row][col].isFixed) {
            if (col == 8) {
                dfs(row + 1, 0);
            } else {
                dfs(row, col + 1);
            }
        }
        for (int i = 1; i < 10; i++) {
            //这个位置可以填

            if (content[row][col].isFixed == false && isValid(row, col, i)) {
                content[row][col].num = i;
                rowUsed[row][i - 1] = 1;
                colUsed[col][i - 1] = 1;
                blockedUsed[(row / 3) * 3 + col / 3][i - 1] = 1;
                if (col == 8) {
                    dfs(row + 1, 0);
                } else {
                    dfs(row, col + 1);
                }
                rowUsed[row][i - 1] = 0;
                colUsed[col][i - 1] = 0;
                blockedUsed[(row / 3) * 3 + col / 3][i - 1] = 0;
                content[row][col].num = 0;
            }
        }
    }

}

class Piece {
    //该位置是不是固定的数
    boolean isFixed;
    int num = 0;
}



