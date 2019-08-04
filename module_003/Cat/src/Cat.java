
public class Cat
{
    private double originWeight;
    private double weight;
    private double eatenFood;

    private final double MIN_WEIGHT = 1000.0;
    private final double MAX_WEIGHT = 9000.0;
    private final int CATS_EYE_QTY = 2;

    private static int count;

    private Color color;

    public Cat()
    {
        weight = (1500.0 + 3000.0 * Math.random());
        setOriginWeight(getWeight());
        if (isAlive()) {
            count += 1;
        }
        eatenFood = 0;
        color = Color.getRandom();

    }

    public Cat(Cat original) {
        this();
        this.weight = original.getWeight();
        this.originWeight = original.getOriginWeight();
        this.eatenFood = original.getEatenFood();
        this.color = original.getColor();
        if (!isAlive()) {
            count -= 1;
        }
    }

    public Cat(double weight) {
        this();
        this.weight = weight;
        this.originWeight = weight;
        if (!isAlive()) {
            count -= 1;
            System.out.println("Wrong weight, please use ammount between " + MIN_WEIGHT + " and " + MAX_WEIGHT);
        }
    }

    public void meow()
    {
        if (!isAlive()) {
            System.out.println(getStatus());
        } else {
            setWeight(getWeight() - 1);
            System.out.println("Meow");
        }
    }

    public void goToilet()
    {
        if (!isAlive()) {
            System.out.println(getStatus());
        } else {
            setWeight(getWeight() - 0.03 * weight);
            System.out.println("Toilet needs to be cleaned");
        }
    }

    public void feed(Double amount)
    {
        if (!isAlive()) {
            System.out.println(getStatus());
        } else {
            setWeight(getWeight() + amount);
            setEatenFood(getEatenFood() + amount);
        }
    }

    public void drink(Double amount)
    {
        if (!isAlive()) {
            System.out.println(getStatus());
        } else {
            setWeight(getWeight() + amount);
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

    public double getOriginWeight() {
        return originWeight;
    }

    public void setOriginWeight(double originWeight) {
        this.originWeight = originWeight;
    }

    public void setWeight(double weight) {
        if (isAlive()) {
            this.weight = weight;
            if (!isAlive()) {
                count -= 1;
            }
        }
    }

    public void setEatenFood(double eatenFood) {
        this.eatenFood = eatenFood;
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

    public boolean isAlive() {
        return (getWeight() >= MIN_WEIGHT && getWeight() <= MAX_WEIGHT);
    }

    public int getCount() {
        return count;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}