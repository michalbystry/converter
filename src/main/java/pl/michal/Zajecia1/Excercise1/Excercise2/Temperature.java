package pl.michal.Zajecia1.Excercise1.Excercise2;

/**
 * Created by Michał on 2014-10-23.
 */
public class Temperature {
    private String temperatureSyntax;
    private double temperatureValue;
    static boolean isCorrectValue = true;

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

    public void printTemp() {
        if (true == isCorrectValue) {
            System.out.println(getTemperatureValue() + " " + getTemperatureSyntax().toUpperCase());
        }
    }

    public double parsingNumber(String numberSeparated) {
        try {
            return temperatureValue = Double.parseDouble(numberSeparated);
        } catch (NullPointerException ex) {
            System.out.println("test NPE//Incorrect input temperature value");
            this.isCorrectValue = false;
            return 0;
        } catch (NumberFormatException ex) {
            System.out.println("test NFE//Incorrect input temperature value");
            this.isCorrectValue = false;
            return 0;
        }
    }
}




