package Algorithm;

public class IsValidSudoku {

    /**
     * 判断数独是否有效
     * @param board
     * @return boolean
     */
    public boolean isValidSudoku(char[][] board) {
        // 记录每一行、每一列、每个 3x3 宫格中是否出现过某个数字（索引 0-8 对应数字 '1'-'9'）
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][] boxes = new int[9][9];

        // 遍历所有单元格
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // 忽略空白格
                if (board[i][j] == '.') {
                    continue;
                }

                // 将字符数字映射到索引 0-8（'1' -> 0, ..., '9' -> 8）
                int c = board[i][j] - '1';

                // 计算所属 3x3 宫格索引（0-8）
                int index = j / 3 + (i / 3) * 3;

                // 若当前数字在所在行/列/宫格中已出现过，则盘面无效
                if (rows[i][c] == 1 || columns[j][c] == 1 || boxes[index][c] == 1) {
                    return false;
                }

                // 标记该数字在当前行、列、宫格中已出现
                rows[i][c] = 1;
                columns[j][c] = 1;
                boxes[index][c] = 1;
            }
        }
        return true;
    }
}
