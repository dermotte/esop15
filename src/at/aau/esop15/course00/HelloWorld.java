package at.aau.esop15.course00;

import java.util.Arrays;

/**
 * Created by mlux on 03.09.2015.
 */
public class HelloWorld {
public static void main(String[] args) {
    int[] myArray = new int[10];
    for (int i = 0; i < 10; i++) {
        myArray[i] = i;
    }
    int j = 0;
    while (j < 10) {
        int newInt = 10 - myArray[j] + j;
        myArray[j] = newInt;
        j++;
    }
}
}
