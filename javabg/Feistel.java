package javabg;

import javabg.DESbox;

public class Feistel {

    public static int sBoxHelper(int sBox, int value) {
        sBox -= 1;
        // row
        int row = ((value & 0b100000) >> 4) | (value & 0b000001);
        int column = (0b011110 & value) >> 1;
        // System.out.println(row);
        // int row = (maskRow & value) >> 4;
        // column

        // System.out.println("row: " + Integer.toBinaryString(row));
        // System.out.println("column:" + Integer.toBinaryString(column));
        return new DESbox().getSbox(sBox, row, column);
    }

    public static int feistel(int initial, int key, int rounds) {
        if (rounds < 1) {
            return initial;
        }
        int leftSide = (0b11110000 & initial) >> 4;
        int rightSide = (0b00001111 & initial);
        int roundFunction = (rightSide | key);
        int endRight = leftSide ^ roundFunction;

        System.out.println("Function Bits: " + Integer.toBinaryString(roundFunction));
        System.out.println("Left: " + Integer.toBinaryString(leftSide) + "Right: " + Integer.toBinaryString(endRight));
        return feistel(((rightSide << 4) | endRight), key, --rounds);

    }

    public static void main(String[] args) {
        int test = 0b100101;
        // System.out.println(sBoxHelper(5, test));
        System.out.println(Integer.toBinaryString(feistel(0b01011100, 0b1001, 2)));
        System.out.println(sBoxHelper(2, 0b011001));
    }
}
