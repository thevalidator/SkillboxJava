
public class Loader
{
    public static void main(String[] args)
    {
        Cat cat = new Cat(50000.0);
        System.out.println(cat.getWeight());

        Cat cat1 = new Cat();
        System.out.println("\n" + "cat 1:" + "\n" + "=============================");
        System.out.println("weight: " + cat1.getWeight());
        cat1.feed(20000.);
        System.out.println("weight after feedng: " + cat1.getWeight());
        System.out.println(cat1.getEatenFood());
        System.out.println("status: " + cat1.getStatus());
        cat1.meow();

        Cat cat2 = new Cat();
        System.out.println("\n" + "cat 2:" + "\n" + "=============================");
        System.out.println("weight: " + cat2.getWeight());
        cat2.drink(30.);
        System.out.println("weight after drinking: " + cat2.getWeight());
        System.out.println("status: " + cat2.getStatus());

        Cat cat3 = new Cat();
        System.out.println("\n" + "cat 3:" + "\n" + "=============================");
        System.out.println("weight: " + cat3.getWeight());
        cat3.goToilet();
        System.out.println(cat3.getWeight());

        Cat cat4 = new Cat();
        System.out.println("\n" + "cat 4:" + "\n" + "=============================");
        System.out.println("weight: " + cat4.getWeight());

        Cat cat5 = new Cat();
        System.out.println("\n" + "cat 5:" + "\n" + "=============================");
        System.out.println("weight: " + cat5.getWeight());
        while (cat5.isAlive()) {
            cat5.meow();
        }
        System.out.println("status: " + cat5.getStatus());

        System.out.println("Alive cats: " + cat.getCount());
        System.out.println("status: " + cat1.getStatus());
        System.out.println("Alive cats: " + cat.getCount());
        cat5.feed(1000.);

        cat3.feed(150.);
        Cat cat3Copy = new Cat(cat3);
        System.out.println("------CAT3 and CAT3 COPY------");
        System.out.println("cat3     (weight, originWeigth, eatenFood, isAlive, color): " + cat3.getWeight() + ", " + cat3.getOriginWeight() + ", " + cat3.getEatenFood() + ", " + cat3.isAlive() + ", " + cat3.getColor());
        System.out.println("cat3Copy (weight, originWeigth, eatenFood, isAlive, color): " + cat3Copy.getWeight() + ", " + cat3Copy.getOriginWeight() + ", " + cat3Copy.getEatenFood() + ", " + cat3Copy.isAlive() + ", " + cat3Copy.getColor());
        System.out.println("Alive cats: " + cat.getCount());

        System.out.println();

        System.out.println("Cat1 color: " + cat1.getColor());
        System.out.println("Cat2 color: " + cat2.getColor());
        System.out.println("Cat3 color: " + cat3.getColor());

        cat1.setColor(Color.RED);
        cat2.setColor(Color.GREY);
        cat3.setColor(Color.BLACK);
        System.out.println();

        System.out.println("Cat1 color: " + cat1.getColor());
        System.out.println("Cat2 color: " + cat2.getColor());
        System.out.println("Cat3 color: " + cat3.getColor());


    }
}