import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLOutput;

public class Loader {

    public static final double MIN_TEMPERATURE = 36.2;
    public static final double MAX_TEMPERATURE = 36.9;

    public static void main(String[] args) {

        double[] temperatures = new double[29];

        for (int human = 0; human < temperatures.length; human++) {
            temperatures[human] = new BigDecimal(32. + (Math.random() * 8.)).setScale(1, RoundingMode.HALF_UP).doubleValue();
        }

        for (double human : temperatures) {
            System.out.print(human + ", ");
        }

        System.out.println("\n" +"Healthy people: " + getHealthyPeopleAmmount(temperatures) + ", Average temp: " + getAverageTemperature(temperatures));

    }

    public static int getHealthyPeopleAmmount(double[] temperatureList) {
        int healthyPeopleAmmount = 0;
        for ( int i = 0; i < temperatureList.length; i++) {
            if (temperatureList[i] <= MAX_TEMPERATURE && temperatureList[i] >= MIN_TEMPERATURE) {
                healthyPeopleAmmount ++;
            }
        }
        return healthyPeopleAmmount;
    }

    public static double getAverageTemperature(double[] temperatureList) {
        double averageTemperature = 0.;
        for ( int i = 0; i < temperatureList.length; i++) {
            averageTemperature += temperatureList[i];
        }
        return (averageTemperature / temperatureList.length);
    }

}
