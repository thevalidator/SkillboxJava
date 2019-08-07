public class Main
{
    public static void main(String[] args)
    {
        Container container = new Container();
        container.count += 7843;

        int sum = sumDigits(12300456);
        System.out.println("Сумма всех цифр числа равна: " + sum);

     //   byte.int.short.long.double,float
        System.out.println("   int: " +  Integer.MAX_VALUE + " / " + Integer.MIN_VALUE);
        System.out.println("double: " +  Double.MAX_VALUE + " / " + Double.MIN_VALUE);
        System.out.println("  byte: " +  Byte.MAX_VALUE + " / " + Byte.MIN_VALUE);
        System.out.println(" float: " +  Float.MAX_VALUE + " / " + Float.MIN_VALUE);
        System.out.println("  long: " +  Long.MAX_VALUE + " / " + Long.MIN_VALUE);
        System.out.println(" short: " +  Short.MAX_VALUE + " / " + Short.MIN_VALUE);

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
