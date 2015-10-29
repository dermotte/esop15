package at.aau.esop15.course04;

/**
 * @author Dr. Mathias Lux, mlux@itec.aau.at, 29.10.2015 13:01.
 */
public class ArrayExample {
    public static void main(String[] args) {
        int[] myArray = new int[5];
        // initialisiere Werte in Array: {1, 2, 3, 4, 5}
        int i=0;
        while (i<myArray.length) {
            myArray[i] = i + 1;
            i++;
        }
        // Compute mean:
        float sum = 0;
        for (int element : myArray) {
            sum += element; // sum up all elements
        }
        System.out.println(sum / myArray.length);
    }
}

