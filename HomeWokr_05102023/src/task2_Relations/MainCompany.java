package task2_Relations;

public class MainCompany {
    public static void main(String[] args) {
        Company company = new Company("Рога и копыта");
        Emploee emploee1 = new Emploee("Остап", "Бендер", "1");
        Department department = new Department("Администрация", emploee1, company);

        System.out.println("Компания " + company.getName());
        System.out.println("Департамент " + department.getName());
        System.out.println("Директор департамента " + department.getBoss().toString() );
        System.out.println("Сотрудник " + emploee1.getFirstName() + " " + emploee1.getLastName());
    }
}
