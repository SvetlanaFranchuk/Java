package task2_Relations;

public class Department {
    //композиция (в отношении департамент - босс) - при создании нового департамента мы создаем нового босса (начальника департамента)
    //агрегация в отношениях компания - департамет. Департамент содержит ссылку на компанию
    private String name;
    private Boss boss;

    private Company company;

    public Department(String name, Emploee emploee, Company company) {
        this.name = name;
        this.boss = new Boss(emploee);
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public Boss getBoss() {
        return boss;
    }

    public Company getCompany() {
        return company;
    }
}
