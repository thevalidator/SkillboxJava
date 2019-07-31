package core;

public class Car
{
    // переменная number типа string
    private String number;
    // переменная height типа int
    private int height;
    // переменная weight типа double
    private double weight;
    // переменная hasVehicle типа boolean
    private boolean hasVehicle;
    // переменная isSpecial типа boolean
    private boolean isSpecial;

    public String toString()
    {
        // создание переменной special типа String
        String special = isSpecial() ? "СПЕЦТРАНСПОРТ " : "";
        return "\n=========================================\n" +
            special + "Автомобиль с номером " + number +
            ":\n\tВысота: " + height + " мм\n\tМасса: " + weight + " кг";
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean hasVehicle() {
        return hasVehicle;
    }

    public void setVehicle(boolean vehicle) {
        this.hasVehicle = vehicle;
    }

    public boolean isSpecial() {
        return isSpecial;
    }

    public void setSpecial(boolean special) {
        this.isSpecial = special;
    }
}