
public class Cat
{
    private double originWeight;
    private double weight;
    private double eatenFood;

    private final double MIN_WEIGHT = 1000.0;
    private final double MAX_WEIGHT = 9000.0;
    private final int CATS_EYE_QTY = 2;

    private static int count = 0;

    private Color color;

    public Cat()
    {
        this((1500.0 + 3000.0 * Math.random()), 0., 0.,Color.getRandom());
    }

    public Cat(double weight, double originWeight, double eatenFood, Color color) {
        this.weight = weight;
        this.originWeight = originWeight;
        this.eatenFood = eatenFood;
        this.color = color;
        if (isAlive()) {
            count += 1;
        }
    }

    public Cat(Cat original) {
        this(original.getWeight(), original.getOriginWeight(), original.getEatenFood(), original.getColor());
    }

    public Cat(double weight) {
        this(weight, weight, 0, Color.getRandom());
        if (!isAlive()) {
            System.out.println("Wrong weight, please use ammount between " + MIN_WEIGHT + " and " + MAX_WEIGHT);
        }
    }

    public Cat createTwin() {
        return new Cat(getWeight(), getOriginWeight(), getEatenFood(), getColor());
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