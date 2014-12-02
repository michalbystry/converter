package pl.michal.Zajecia1.Excercise1.Excercise2;

/**
 * Created by Michał on 2014-10-23.
 */
public class Temperature {
    private String temperatureSyntax;
    private double temperatureValue;


    public void setTemperatureSyntax(String temperatureSyntax) {
        this.temperatureSyntax = temperatureSyntax;
    }

    public void setTemperatureValue(double temperatureValue) {
        this.temperatureValue = temperatureValue;
    }

    public double getTemperatureValue() {
        return temperatureValue;
    }

    public String getTemperatureSyntax() {
        return temperatureSyntax;
    }

//    public void printTemp() {
//        if (true == isCorrectValue) {
//            System.out.println(getTemperatureValue() + " " + getTemperatureSyntax().toUpperCase());
//        }
//    }

    public double parsingNumber(String numberSeparated) {
        if (null != numberSeparated) {
            try {
                return temperatureValue = Double.parseDouble(numberSeparated);
            } catch (NumberFormatException ex) {
                System.out.println("test NFE//Incorrect input temperature value");
                return 0;
            }
        }
        System.out.println("test//NPE");
        return 0;
    }
}




