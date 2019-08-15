public class Loader {
    public static void main(String[] args)
    {
        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";

        System.out.println(text);

        char vasya = '5';
        char petya = '7';
        char masha = '3';

        // indexOf() возвращает индекс символа или набора символов в тексте (''/""/ '', index/ "", index)
        // lastIndexOf() то же самое, но справа налево ищет
        // substring() возвращает часть строки (start index /start index, end index)
        // trim() удаляет пробелы с обоих концов

        int vasyaSalary = Integer.parseInt(text.substring(text.indexOf(vasya), (text.indexOf(vasya) + 4)));
        int petyaSalary = Integer.parseInt(text.substring(text.indexOf(petya), (text.indexOf(petya) + 4)));
        int mashaSalary = Integer.parseInt(text.substring(text.lastIndexOf(masha), (text.lastIndexOf(masha) + 5)));
        System.out.println("Суммарный заработок ребят составил " + (vasyaSalary + petyaSalary + mashaSalary) + " рублей.");
    }

}
