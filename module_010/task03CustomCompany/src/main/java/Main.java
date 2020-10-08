import Workfiles.Company;


public class Main {

    public static void main(String[] args) {

        /*String topManager = "topManager";
        String manager = "manager";
        String operator = "operator";

        int num = 2;
        Company drova = new Company();
        Company roga = new Company();
        Company kopyta = new Company();

        drova.setCompanyName("DROVA");
        roga.setCompanyName("ROGA");
        kopyta.setCompanyName("KOPYTA");

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
        System.out.println(kopyta.getCompanyIncome());*/

        StudentModel studentModel = new StudentModel();

        Student nikita = new Student();
        nikita.setName("Nikita");
        nikita.setUniversity("MGIMO");

        Student babkaStudent = new Student();
        babkaStudent.setName("Babka");
        babkaStudent.setUniversity("PTU-31");

        Student dedStudent = new Student();
        dedStudent.setName("Ded");
        dedStudent.setUniversity("Garvard College");

        studentModel.create(nikita);
        studentModel.create(babkaStudent);
        studentModel.create(dedStudent);

        for(Student student : studentModel.findAll()) {
            System.out.println("ID: " + student.getId() + ", NAME: " + student.getName() + ", UNIVERSITY: " +
                    student.getUniversity());
        }

    }
}
