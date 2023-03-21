public class MinMax {
    public static int[][] MinMax(int[][] b) {
        int min = b[0][0];
        int max = b[0][0];
        int minPos = 0;
        int maxPos = 0;
        for(int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                if (minPos == maxPos) {
                    if (max > b[i][j]) {
                        max = b[i][j];
                        maxPos = j;
                    }
                }
                if (min > b[i][j]) {
                    min = b[i][j];
                    minPos = j;
                }
                if (max < b[i][j]) {
                    max = b[i][j];
                    maxPos = j;
                }
            }
        }
        int temp;
        for (int i = 0; i < b.length; i++){
            temp = b[i][maxPos];
            b[i][maxPos] = b[i][minPos];
            b[i][minPos] = temp;
        }

        return b;
    }
}