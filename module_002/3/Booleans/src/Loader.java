
public class Loader
{
    public static void main(String[] args)
    {
        int milkAmount = 800; // ml
        int powderAmount = 5505; // g
        int eggsCount = 5103; // items
        int sugarAmount = 5105; // g
        int oilAmount = 51030; // ml
        int appleCount = 3;

        boolean pancakes = false;
        boolean omlette = false;
        boolean applePie = false;

        //powder - 400 g, sugar - 10 g, milk - 1 l, oil - 30 ml
        if (milkAmount >= 1000 && powderAmount >= 400 && sugarAmount >= 10 && oilAmount >= 8) {
            pancakes = true;
        }
        //milk - 300 ml, powder - 5 g, eggs - 5
        if (milkAmount >= 300 && powderAmount >= 5 && eggsCount >= 5) {
            omlette = true;
        }
        //apples - 3, milk - 100 ml, powder - 300 g, eggs - 4
        if (appleCount >=3 && milkAmount >= 100 && powderAmount >= 300 && eggsCount >= 4)
        {
            applePie = true;
        }

        if (!pancakes && !omlette && !applePie){
            System.out.println("Not enough ingridients!");
        } else {
            if (pancakes) {
              System.out.println("You can cook Pancakes");
            }
            if (applePie) {
              System.out.println("You can cook Apple pie");
            }
            if (omlette) {
              System.out.println("You can cook Omelette");
            }
        }
    }
}
