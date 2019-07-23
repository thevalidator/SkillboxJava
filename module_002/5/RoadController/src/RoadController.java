import core.*;
import core.Camera;

import java.util.Scanner;

public class RoadController
{
    // переменная passengerCarMaxWeight типа double
    private static double passengerCarMaxWeight = 3500.0; // kg
    // переменная passengerCarMaxHeight типа int
    private static int passengerCarMaxHeight = 2000; // mm
    // переменная controllerMaxHeight типа int
    private static int controllerMaxHeight = 3500; // mm

    // переменная passengerCarPrice типа int
    private static int passengerCarPrice = 100; // RUB
    // переменная cargoCarPrice типа int
    private static int cargoCarPrice = 250; // RUB
    // переменная vehicleAdditionalPrice типа int
    private static int vehicleAdditionalPrice = 200; // RUB

    public static void main(String[] args)
    {
        System.out.println("Сколько автомобилей сгенерировать?");
    // создание объекта scanner
        Scanner scanner = new Scanner(System.in);
        // переменная carsCount типа int
        int carsCount = scanner.nextInt();

        // переменная i типа int
        for(int i = 0; i < carsCount; i++)
        {
            // создание объекта car
            Car car = Camera.getNextCar();
            System.out.println(car);

            //Пропускаем автомобили спецтранспорта бесплатно
            if (car.isSpecial) {
                openWay();
                continue;
            }

            //Проверяем высоту и массу автомобиля, вычисляем стоимость проезда
            // переменная price типа int
            int price = calculatePrice(car);
            if(price == -1) {
                continue;
            }

            System.out.println("Общая сумма к оплате: " + price + " руб.");
        }
    }

    /**
     * Расчёт стоимости проезда исходя из массы и высоты
     */
    private static int calculatePrice(Car car)
    {
        // переменная carHeight типа int
        int carHeight = car.height;
        // переменная int типа int
        int price = 0;
        if (carHeight > controllerMaxHeight)
        {
            blockWay("высота вашего ТС превышает высоту пропускного пункта!");
            return -1;
        }
        else if (carHeight > passengerCarMaxHeight)
        {
            // переменная weight типа double
            double weight = car.weight;
            //Грузовой автомобиль
            if (weight > passengerCarMaxWeight)
            {
                price = cargoCarPrice;
                if (car.hasVehicle) {
                    price = price + vehicleAdditionalPrice;
                }
            }
            //Легковой автомобиль
            else {
                price = passengerCarPrice;
            }
        }
        else {
            price = passengerCarPrice;
        }
        return price;
    }

    /**
     * Открытие шлагбаума
     */
    private static void openWay()
    {
        System.out.println("Шлагбаум открывается... Счастливого пути!");
    }

    /**
     * Сообщение о невозможности проезда
     */
    // переменная reason типа String
    private static void blockWay(String reason)
    {
        System.out.println("Проезд невозможен: " + reason);
    }
}