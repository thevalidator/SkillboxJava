public class Loader {
    public static void main(String[] args) {
        int length = 7;

        String[][] bigX = new String[length][length];

        for (int i = 0; i < bigX.length; i++) {
            for (int j = 0; j < bigX[i].length; j++) {
                if (i == j || j == (bigX[i].length - i -1)) {
                    bigX[i][j] = "x";
                } else {
                    bigX[i][j] = " ";
                }
                System.out.print(bigX[i][j]);
            }
            System.out.println();
        }

    }
}
