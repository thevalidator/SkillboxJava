public class Main
{
    public static void main(String[] args)
    {
        Container container = new Container();
        container.count += 7843;

        int sum = sumDigits(12300456);
        System.out.println("Сумма всех цифр числа равна: " + sum);
    }

    public static Integer sumDigits(Integer number)
    {
        //@TODO: write code here
        String string = Integer.toString(number);
        int summ = 0;
        for (int i = 0; i < string.length(); i++) {
            char simbol = string.charAt(i);
            summ += Character.getNumericValue(simbol);
        }
        return summ;
    }
}
