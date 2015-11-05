package at.aau.esop15.course05;

/**
 * @author Dr. Mathias Lux, 05.11.2015.
 */
public class MultiDimensionalArray {
    public static void main(String[] args) {
        int[][] myArray = new int[3][];

        // fill array with values to create a matrix
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = new int[] {i*3+1, i*3+2, i*3+3};
        }

        // transpose matrix
        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray[i].length; j++) {
                if (j<i) {
                    int tmp = myArray[i][j];
                    myArray[i][j] = myArray[j][i];
                    myArray[j][i] = tmp;
                }
            }
        }

        // print array to System.out
        for (int i = 0; i < myArray.length; i++) {
            int[] ints = myArray[i];
            System.out.printf("%2d\t%2d\t%2d\n", ints[0], ints[1], ints[2]);
        }
    }
}
