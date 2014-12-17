package pl.michal.Zajecia1.Excercise1.Excercise2;

import pl.michal.kalkulator.*;



/**
 * Created by Michał on 2014-10-09.
 */
public class Ex1 {

    public enum AvailableTemp {C, K, F}


    String temp1 = "C";
    String temp2 = "F";
    double tempValue1;
    double tempValue2;

    public void calculateTemp(double temperatureValue, String temperatureSyntax) {

        switch (AvailableTemp.valueOf(temp2)) {
            case C:
                calculateC(temperatureValue);

                break;
            case K:
                calculate_KC(temperatureValue);
                break;
            case F:
                calculate_FC(temperatureValue);
                break;
        }
    }

    public void calculate_KC(double tempValue) {
        tempValue2=tempValue - 273.80;
    }
    public void calculate_FC(double tempValue) {
        tempValue2= tempValue / 2;
    }
    public void calculateC(double tempValue) {
        tempValue2= tempValue;
    }




    public static void main(String[] args) {
Ex1 testCalc = new Ex1();

        testCalc.calculateTemp(100.00, testCalc.temp1 );
        System.out.println(testCalc.tempValue2);

    }
}