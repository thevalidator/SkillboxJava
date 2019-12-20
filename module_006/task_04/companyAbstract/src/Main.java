import Workfiles.Company;

public class Main {
    public static void main(String[] args) {
        String topManager = "topManager";
        String manager = "manager";
        String operator = "operator";

        int num = 2;
        Company drova = new Company();
        Company roga = new Company();
        Company kopyta = new Company();

        drova.hire(manager);
        drova.hire(topManager);

        roga.hire(manager);
        roga.hire(operator);
        roga.hire(topManager);

        kopyta.hireAll();

        System.out.println(drova.getCompanyIncome());
        System.out.println(drova.employeeList.size());
        System.out.println(drova.employeeList.get(0).getMonthSalary());
        drova.getLowSalaryStaff(num);
        drova.getTopSalaryStaff(num);

        roga.getLowSalaryStaff(num);
        roga.getTopSalaryStaff(num);

        kopyta.getTopSalaryStaff(15);
        roga.getTopSalaryStaff(2);

        System.out.println(drova.getCompanyIncome());
        System.out.println(roga.getCompanyIncome());
        System.out.println(kopyta.getCompanyIncome());
    }
}
