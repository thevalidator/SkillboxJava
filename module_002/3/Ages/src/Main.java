public class Main {
    public static void main(String[] args) {
        int vasyaAge = 22;
        int katyaAge = 8;
        int mishaAge = 78;

        int min = 0;
        int middle = 0;
        int max = 0;


        if (vasyaAge >= katyaAge) {
            middle = katyaAge;
            max = vasyaAge;
            if (mishaAge <= middle) {
                min = mishaAge;
            } else {
                if (mishaAge >= vasyaAge) {
                    max = mishaAge;
                    middle = vasyaAge;
                    min = katyaAge;
                } else {
                    middle = mishaAge;
                }
            }
        } else {
            max = katyaAge;
            middle = vasyaAge;
            if (mishaAge <= vasyaAge) {
                min = mishaAge;
            } else {
                middle = mishaAge;
                min = vasyaAge;
            }
        }
        System.out.println("Max: " + max + ", Middle: " + middle + ", Min: " + min);
    }
}
