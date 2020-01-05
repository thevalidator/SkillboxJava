import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main
{
    private static String staffFile = "data/staff.txt";
    private static String dateFormat = "dd.MM.yyyy";

    public static void main(String[] args) throws ParseException {
        ArrayList<Employee> staff = loadStaffFromFile();

//        staff.sort((o1, o2) -> {int salaryComp = o1.getSalary().compareTo(o2.getSalary());
//            if (salaryComp == 0) {
//                return o1.getName().compareTo(o2.getName());
//            } else {
//                return salaryComp;
//            }});

//        staff.sort(Comparator.comparing(Employee::getSalary).thenComparing(Employee::getName));

//        for (Employee employee : staff) {
//            System.out.println(employee);
//        }

        System.out.print("Top paid employee came after 2016 year: ");
        Date filterDate = new SimpleDateFormat(dateFormat).parse("31.12.2016");

        staff.stream()
                .filter(e -> e.getWorkStart().after(filterDate))
                .max(Comparator.comparing(Employee::getSalary))
                .ifPresent(System.out::println);

        //что то такое и почему так??? Если использовать параллельный поток, то результат разный или ошибка
//        final List<Integer> ints = new ArrayList<>();
//        IntStream.range(0, 1000000)
//                .parallel()
//                .forEach(i -> ints.add(i));
//        System.out.println(ints.size());


    }

    private static ArrayList<Employee> loadStaffFromFile()
    {
        ArrayList<Employee> staff = new ArrayList<>();
        try
        {
            List<String> lines = Files.readAllLines(Paths.get(staffFile));
            for(String line : lines)
            {
                String[] fragments = line.split("\t");
                if(fragments.length != 3) {
                    System.out.println("Wrong line: " + line);
                    continue;
                }
                staff.add(new Employee(
                    fragments[0],
                    Integer.parseInt(fragments[1]),
                    (new SimpleDateFormat(dateFormat)).parse(fragments[2])
                ));
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return staff;
    }
}