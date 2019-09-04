public class Loader {
    public static void main(String[] args) {
        String text = "Каждый охотник желает знать, где сидит фазан";

        String[] colors = text.split(",?\\s+");

        for (String words : colors) {
            System.out.println(words);
        }

        for (int i = 0; i < colors.length/2; i++) {
            String temp = colors[i];
            colors[i] = colors[colors.length - 1 - i];
            colors[colors.length - 1 - i] = temp;
        }

        System.out.println("------");

        for (String words : colors) {
            System.out.println(words);
        }
    }
}
