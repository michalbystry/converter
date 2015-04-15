package pl.michal.Zajecia1.Excercise1.Excercise2;

import pl.michal.Lab2_1.Test;
import pl.michal.kalkulator.*;



/**
 * Created by Michał on 2014-10-09.
 */
public class Ex1 {




    String temp1 = "C";
    String temp2 = "F";
    double tempValue1;
    double tempValue2;

    public void calculateTemp(double temperatureValue, String temperatureSyntax) {

        switch (Tester.AvailableTemp.valueOf(temp2)) {
            case C:
                Tester.AvailableTemp.C.convertFromC(temperatureValue, Ex1.this);
                break;
            case K:
                Tester.AvailableTemp.K.convertToC(temperatureValue,Ex1.this);
                Tester.AvailableTemp.K.convertFromC(Tester.AvailableTemp.F.convertToC(temperatureValue,Ex1.this),Ex1.this);
                break;
            case F:

                break;
        }
    }





    public static void main(String[] args) {
Ex1 testCalc = new Ex1();

        testCalc.calculateTemp(100.00, testCalc.temp1 );
        System.out.println(testCalc.tempValue2);

    }
}