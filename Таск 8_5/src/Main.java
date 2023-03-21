import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class Main {

        public static void main(String[] args) {
                int[][] array = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
                int[][] result = flipColumns(array);
                printArray(result);
        }

        @NotNull
        private static int[][] flipColumns(int[][] array) {
                int[][] result = new int[array[0].length][array.length];
                int counter = 0;
                for (int[] ints : array) {
                        for (int i = 0; i < ints.length; i++) {
                                result[i][counter] = ints[i];
                        }
                        counter++;
                }
                return result;
        }

        public static void printArray(int[][] array) {
                for (int[] ints : array) {
                        for (int j = 0; j < 1; j++) {
                                System.out.println();
                        }
                        System.out.print(Arrays.toString(ints));
                }
        }
}