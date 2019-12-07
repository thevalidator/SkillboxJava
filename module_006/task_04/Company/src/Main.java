import WorkFiles.Company;

public class Main {
    public static void main(String[] args) {

        Company CocaCola = new Company();
        Company GazProm = new Company();

        GazProm.hire();
        GazProm.hire();
        GazProm.hire();
        GazProm.hire();
        GazProm.hire();
        GazProm.hire();
        GazProm.hire();
        GazProm.fire();

        CocaCola.hireAll();
        GazProm.hireAll();


        System.out.print((int)GazProm.getCompanyIncome() + "  GazProm | income |  CocaCola  ");
        System.out.println((int)CocaCola.getCompanyIncome());

//        System.out.print(GazProm.EmployeeList.get(0).getMonthSalary(GazProm, GazProm.getCompanyIncome()) + "GazProm |  ЗП менеджера  | CocaCola  ");
//        System.out.println(CocaCola.EmployeeList.get(0).getMonthSalary(CocaCola, CocaCola.getCompanyIncome()));

//        double compInc = GazProm.getCompanyIncome();
//        for (int i = 0; i < GazProm.EmployeeList.size(); i++) {
//            System.out.println(GazProm.EmployeeList.get(i).getMonthSalary(GazProm, compInc));
//        }


        int number = 5;
        GazProm.getTopSalaryStaff(number);
        GazProm.getLowSalaryStaff(number);


//        for (int i = 0; i < GazProm.EmployeeList.size(); i++) {
//            System.out.println(GazProm.EmployeeList.get(i).getMonthSalary(GazProm, compInc));
//        }


    }
}
