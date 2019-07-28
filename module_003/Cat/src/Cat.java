
public class Cat
{
    private double originWeight;
    private double weight;
    private double eatenFood;

    private final double MIN_WEIGHT = 1000.0;
    private final double MAX_WEIGHT = 9000.0;
    private final int CATS_EYE_QTY = 2;

    public boolean isAlive;
    private static int count;

    public Cat()
    {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        isAlive = true;
        count += 1;
        eatenFood = 0;
    }

    public Cat(double weight){
        this();
        this.weight = weight;
        isAlive();
        if (!isAlive) {
            System.out.println("Wrong weight, please use ammount between " + MIN_WEIGHT + " and " + MAX_WEIGHT);
        }
    }

    public void meow()
    {
        if (isAlive) {
            weight -= 1;
            isAlive();
            System.out.println("Meow");
        } else {
            System.out.println(getStatus());
        }
    }

    public void goToilet()
    {
        if (isAlive) {
            weight -= 0.03 * weight;
            isAlive();
            System.out.println("Toilet needs to be cleaned");
        } else {
            System.out.println(getStatus());
        }
    }

    public void feed(Double amount)
    {
        if (isAlive) {
            weight += amount;
            eatenFood += + amount;
            isAlive();
        } else {
            System.out.println(getStatus());
        }
    }

    public void drink(Double amount)
    {
        if (isAlive) {
            weight += amount;
            isAlive();
        } else {
            System.out.println(getStatus());
        }
    }

    public Double getEatenFood()
    {
        return eatenFood;
    }

    public Double getWeight()
    {
        return weight;
    }

    public String getStatus()
    {
        if(weight < MIN_WEIGHT) {
            return "Dead";
        }
        else if(weight > MAX_WEIGHT) {
            return "Exploded";
        }
        else if(weight > originWeight) {
            return "Sleeping";
        }
        else {
            return "Playing";
        }
    }

    public void isAlive() {
        if (getWeight() < MIN_WEIGHT || getWeight() > MAX_WEIGHT) {
            count -= 1;
            isAlive = false;
        }
    }

    public int getCount() {
        return count;
    }

}