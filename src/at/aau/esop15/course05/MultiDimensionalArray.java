package at.aau.esop15.course05;

/**
 * @author Dr. Mathias Lux, 05.11.2015.
 */
public class MultiDimensionalArray {
    public static void main(String[] args) {
        int len = 5;
        int[][] myArray = new int[len][len];

        // fill array with values to create a matrix
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                myArray[i][j] = i * len + j + 1;
            }
        }
        // transpose matrix
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (j>i) {
                    int tmp = myArray[i][j];
                    myArray[i][j] = myArray[j][i];
                    myArray[j][i] = tmp;
                }
            }
        }

        // print array to System.out
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                System.out.print(myArray[i][j] + " ");
            }
            System.out.println();
        }

    }
}
