package desafioPortugal;

import java.util.Objects;

public class TemperatureClosedToZero {

    public static void main(String[] args) {
        int[] temperatures = new int[14];
        temperatures[0] = -7;
        temperatures[1] = -10;
        temperatures[2] = -16;
        temperatures[3] = 1;
        temperatures[4] = 4;
        temperatures[5] = -7;
        temperatures[6] = -12;
        temperatures[7] = -3;
        temperatures[8] = -1;
        temperatures[9] = -9;
        temperatures[10] = 6;
        temperatures[11] = -13;
        temperatures[12] = 1;
        temperatures[13] = 7;

        System.out.println(computeClosestToZero(temperatures));
    }

    public static int computeClosestToZero(int[] temperatures) {
        int closeZero = 0;
        if(Objects.isNull(temperatures))
            return closeZero;
        if(temperatures.length == 0 || temperatures.length > 10000)
            return closeZero;
        if(temperatures.length == 1)
            return temperatures[0];

        closeZero = temperatures[0];
        for (int i = 0; i < temperatures.length; i++) {
            if(temperatures[i] == 0) {
                closeZero = temperatures[i];
                break;
            }
           if(firstValueIsGreaterSecondValue(closeZero, temperatures[i])) {
               System.out.println("posi: " + i);
               closeZero = temperatures[i];
               System.out.println(closeZero);
           }
        }
        return closeZero;
    }

    private static boolean firstValueIsGreaterSecondValue(int firstValue, int secondValue) {
        int firstValueConvert = convertPositive(firstValue);
        int secondValueConvert = convertPositive(secondValue);
        if(firstValueConvert == secondValueConvert && firstValue < secondValue)
           return true;
        return firstValueConvert > secondValueConvert;
    }
    private static int convertPositive(int value) {
        return value < 0 ? value * -1 : value;
    }
}