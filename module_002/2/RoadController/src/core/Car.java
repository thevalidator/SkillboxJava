package core;

public class Car
{
    // переменная number типа string
    public String number;
    // переменная height типа int
    public int height;
    // переменная weight типа double
    public double weight;
    // переменная hasVehicle типа boolean
    public boolean hasVehicle;
    // переменная isSpecial типа boolean
    public boolean isSpecial;

    public String toString()
    {
        // создание переменной special типа String
        String special = isSpecial ? "СПЕЦТРАНСПОРТ " : "";
        return "\n=========================================\n" +
            special + "Автомобиль с номером " + number +
            ":\n\tВысота: " + height + " мм\n\tМасса: " + weight + " кг";
    }
}