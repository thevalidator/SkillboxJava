import WorkFiles.Company;
import WorkFiles.Manager;
import WorkFiles.Operator;
import WorkFiles.TopManager;

public class Main {
    public static void main(String[] args) {

        Company cocaCola = new Company();
        Company gazProm = new Company();

        for (int i = 1; i < 9; i++) {
            double positionDefinition = Math.random();
            if (positionDefinition < 0.04) {
                gazProm.hire(new TopManager());
                System.out.println("Welcome, Top Manager!");
            } else if (positionDefinition < 0.70 && positionDefinition >= 0.4) {
                gazProm.hire(new Operator());
                System.out.println("Welcome, Operator!");
            } else {
                gazProm.hire(new Manager());
                System.out.println("Welcome, Manager!");
            }
        }

        gazProm.fire((int) (Math.random() * gazProm.employeeList.size()));

        cocaCola.hireAll();
        gazProm.hireAll();

        System.out.print((int)gazProm.getCompanyIncome() + "  gazProm | income |  cocaCola  ");
        System.out.println((int)cocaCola.getCompanyIncome());

        int number = 5;
        gazProm.getTopSalaryStaff(number);
        gazProm.getLowSalaryStaff(number);

        System.out.println(0.3 == 0.1 + 0.2);
        System.out.println(Double.compare(0.3, (0.1 + 0.2)));

    }
}
