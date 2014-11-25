package pl.michal.Zajecia1.Excercise1.Excercise2;

import pl.michal.kalkulator.*;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Michał on 2014-10-09.
 */
public class Ex1 {

    private String numberSeparated;
    String testSyntax;


    public static void main(String[] args) {
        Ex1 temporaryTemp = new Ex1();
        Temperature firstTemperature = new Temperature();
        Temperature secondTemperature = new Temperature();
        Calculator calculator = new Calculator();

        //farmatting temp values
        DecimalFormat decimalF = new DecimalFormat("#########0.00");

        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(2);

        System.out.println("Give temperature to convert: ");
        Scanner input = new Scanner(System.in);
        String inputTemporary = input.nextLine();

        //receives temp syntax to convert to
        System.out.println("Give temperature syntax to convert to: "); //ALBO WYSWIETLIC DOSTEPNE TEMP??-jak?
        Scanner output = new Scanner(System.in);
        String temporaryOutputTempSyntax = output.nextLine();

        Pattern patternNumber = Pattern.compile("\\d+.?\\d+");
        Matcher matcherNumber = patternNumber.matcher(inputTemporary);

        //finds temperature value as a String
        while ((matcherNumber.find())) {
            temporaryTemp.numberSeparated = matcherNumber.group();
        }

        Pattern patternTemp = Pattern.compile("[a-zA-Z]+");
        Matcher matcherTemp = patternTemp.matcher(inputTemporary);

        //finds first temp syntax
        while ((matcherTemp.find())) {
            firstTemperature.setTemperatureSyntax(matcherTemp.group());
        }

        Pattern outputPatternTemp = Pattern.compile("[a-zA-Z]+");
        Matcher outputMatcherTemp = outputPatternTemp.matcher(temporaryOutputTempSyntax);

        //finds second temp syntax
        while ((outputMatcherTemp.find())) {
            secondTemperature.setTemperatureSyntax(outputMatcherTemp.group());
        }

        //parsing temp value
        firstTemperature.parsingNumber(temporaryTemp.numberSeparated);

        calculator.convertTemperatures(firstTemperature, secondTemperature);

        System.out.println("Input temp: ");
        firstTemperature.printTemp();
        System.out.println("Converted temp: ");
        secondTemperature.printTemp();
    }
}