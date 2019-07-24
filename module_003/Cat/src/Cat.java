
public class Cat
{
    private double originWeight;
    private double weight;

    private double minWeight;
    private double maxWeight;

    public boolean isAlive;

    public Cat()
    {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        minWeight = 1000.0;
        maxWeight = 9000.0;
        isAlive = true;

    }

    public void meow()
    {
        weight = weight - 1;
        getStatus();
        System.out.println("Meow");
    }

    public void feed(Double amount)
    {
        weight = weight + amount;
        getStatus();
    }

    public void drink(Double amount)
    {
        weight = weight + amount;
        getStatus();
    }

    public Double getWeight()
    {
        return weight;
    }

    public String getStatus()
    {
        if(weight < minWeight) {
            isAlive = false;
            return "Dead";
        }
        else if(weight > maxWeight) {
            isAlive = false;
            return "Exploded";
        }
        else if(weight > originWeight) {
            return "Sleeping";
        }
        else {
            return "Playing";
        }
    }
}