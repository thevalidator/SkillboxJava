public class Main {
    public static void main(String[] args) {
        String engAlphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String rusAlphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";

        int engAlphabetLenght = engAlphabet.length();
        int rusAlphabetLenght = rusAlphabet.length();
        // English alphabet letter's codes
        for (int letterNumber = 0; letterNumber < engAlphabetLenght; letterNumber++) {
            System.out.println(engAlphabet.charAt(letterNumber) + ": " + (int) engAlphabet.charAt(letterNumber));
        }
        // Russian alphabet letter's codes
        for (int letterNumber = 0; letterNumber < rusAlphabetLenght; letterNumber++) {
            System.out.println(rusAlphabet.charAt(letterNumber) + ": " + (int) rusAlphabet.charAt(letterNumber));
        }

    }
}
