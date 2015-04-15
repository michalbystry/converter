//package pl.michal.Zajecia1.Excercise1.Excercise2;
//
//import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
//
///**
// * Created by Michał on 2014-10-26.
// */
//public class Calculator {
//    AvailableTempSyntax syntax;
//
//    public enum AvailableTempSyntax {
//        C, F, K
//    }
//
//    //checks if input temp syntax are available in converter - declared in enum and returns correct enum constant for switch
////    public boolean checkAvailabilityOfTemp(Temperature tempSyntax, Temperature tempSyntax2) {
////        try {
////            syntax = AvailableTempSyntax.valueOf(tempSyntax.getTemperatureSyntax().toUpperCase() + tempSyntax2.getTemperatureSyntax().toUpperCase());
////            return true;
////        } catch (IllegalArgumentException ex) {
////            System.out.println("Given temperatures are unsupported for conversion: " + tempSyntax.getTemperatureSyntax() + " and " + tempSyntax2.getTemperatureSyntax());
////            return false;
////        }
////    }
//    public boolean parsingNumber(String numberSeparated, Temperature temp) {
//        if (null != numberSeparated) {
//            try {
//                temp.setTemperatureValue(Double.parseDouble(numberSeparated));
//                return true;
//            } catch (NumberFormatException ex) {
//                System.out.println("test NFE//Incorrect input temperature value");
//                return false;
//            }
//        }
//        System.out.println("test//NPE");
//        return false;
//    }
//
//    public void convertTemperatures(String tempToConvert, Double temperatureValue, Manager manager) {
//        if (manager.isUserInputTemperatureCorrect()) { //CZY DODAC WARUNEK Z DEFAULT?
//            try {
//                switch (AvailableTempSyntax.valueOf(tempToConvert)) {
//                    case C:
//                        convertToF(temperatureValue);
//                        convertToK(temperatureValue);
//                        convertoToC(temperatureValue);
//                        break;
//
//
//                    case F:
//
//                        convertF_C(temperatureValue);
//                        break;
//
//
//                    case K:
//                        convertoK_C(temperatureValue);
//
//                        break;
//
//                }
//            } catch (IllegalArgumentException ex) {
//                System.out.println("Given temperatures are unsupported for conversion");
//            }
//        } else {
//            System.out.println("test// incorrect user input");
//        }
//    }
//
//    public double convertToC(double temperature) {
//        return temperature;
//    }
//
//    public double convertF_C(double temperatureValue) {
//        return (temperatureValue - 32.0 / 1.8);
//    }
//
//    public double convertC_F(double temperatureValue) {
//        return (convertF_C(temperatureValue) * 1.8 + 32.0);
//    }
//
//    public double convertoK_C(double temperatureValue) {
//        return (temperatureValue - 273.15);
//
//    }
//
//    ;
//
//
//    public void convertFromC(String tempToConvert, Double temperatureValue) {
//    }
//
//    public double convertToC(Double temperatureValue) {
//
//
//        //converting temp if input syntax temperatures are defined in enum constants and temp value is correct
//        public void convertTemperatures (Temperature firstTemperature, Temperature secondTemperature, String
//        tempNumberToParse){
//            if (checkAvailabilityOfTemp(firstTemperature, secondTemperature) && parsingNumber(tempNumberToParse, firstTemperature)) { //checking valid temp syntax and input temp value (in case of NPE/NFE)
//                switch (syntax) {
//                    case CF:
//                        celciusConvertToFahrenheit(firstTemperature, secondTemperature);
//                        break;
//                    case FC:
//                        fahrenheitConvertToCelcius(firstTemperature, secondTemperature);
//                        break;
//                    default:
//                        System.out.println("test// Default case in switch statement - incorrect temperature syntaxes");
//                }
//            }
//        }
//
//
//    public void fahrenheitConvertToCelcius(Temperature firstTemperature, Temperature secondTemperature) {
//        secondTemperature.setTemperatureValue(firstTemperature.getTemperatureValue() - 32.0 / 1.8);
//    }
//
//    public void celciusConvertToFahrenheit(Temperature firstTemperature, Temperature secondTemperature) {
//        secondTemperature.setTemperatureValue(firstTemperature.getTemperatureValue() * 1.8 + 32.0);
////        secondTemperature.setTemperatureValue2(firstTemperature.getTemperatureValue() * 1.8 + 32.0); //!!!PROBLEM - NIE PRZEKAZUJE ZMIENNEJ POZA METODE
////        System.out.println("get:"+ secondTemperature.getTemperatureValue2());
//
//    }
//}
