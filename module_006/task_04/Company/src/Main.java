import WorkFiles.Company;
import WorkFiles.Manager;
import WorkFiles.Operator;
import WorkFiles.TopManager;

public class Main {
    public static void main(String[] args) {

        Company CocaCola = new Company();
        Company GazProm = new Company();

        for (int i = 1; i < 9; i++) {
            double positionDefinition = Math.random();
            if (positionDefinition < 0.04) {
                GazProm.hire(new TopManager());
                System.out.println("Welcome, Top Manager!");
            } else if (positionDefinition < 0.70 && positionDefinition >= 0.4) {
                GazProm.hire(new Operator());
                System.out.println("Welcome, Operator!");
            } else {
                GazProm.hire(new Manager());
                System.out.println("Welcome, Manager!");
            }
        }

        GazProm.fire((int) (Math.random() * GazProm.EmployeeList.size()));

        CocaCola.hireAll();
        GazProm.hireAll();

        System.out.print((int)GazProm.getCompanyIncome() + "  GazProm | income |  CocaCola  ");
        System.out.println((int)CocaCola.getCompanyIncome());

        int number = 5;
        GazProm.getTopSalaryStaff(number);
        GazProm.getLowSalaryStaff(number);

    }
}
