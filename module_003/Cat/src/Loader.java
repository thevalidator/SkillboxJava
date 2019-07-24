
public class Loader
{
    public static void main(String[] args)
    {
        Cat cat = new Cat();

        System.out.println(cat.getStatus());

        Cat cat1 = new Cat();
        System.out.println("\n" + "cat 1:" + "\n" + "=============================");
        System.out.println("weight: " + cat1.getWeight());
        cat1.feed(20000.);
        System.out.println("weight after feedng: " + cat1.getWeight());
        System.out.println("status: " + cat1.getStatus());

        Cat cat2 = new Cat();
        System.out.println("\n" + "cat 2:" + "\n" + "=============================");
        System.out.println("weight: " + cat2.getWeight());
        cat2.drink(30.);
        System.out.println("weight after drinking: " + cat2.getWeight());
        System.out.println("status: " + cat2.getStatus());

        Cat cat3 = new Cat();
        System.out.println("\n" + "cat 3:" + "\n" + "=============================");
        System.out.println("weight: " + cat3.getWeight());

        Cat cat4 = new Cat();
        System.out.println("\n" + "cat 4:" + "\n" + "=============================");
        System.out.println("weight: " + cat4.getWeight());

        Cat cat5 = new Cat();
        System.out.println("\n" + "cat 5:" + "\n" + "=============================");
        System.out.println("weight: " + cat5.getWeight());
        while (cat5.isAlive) {
            cat5.meow();
        }
        System.out.println("status: " + cat5.getStatus());
    }
}