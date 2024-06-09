class Contact {
    private String id;
    private String name;
    private String mobile;
    private String company;
    private double salary;
    private String birthday;

    public Contact(String id, String name, String mobile, String company, double salalry, String birthday) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
        this.company = company;
        this.salary = salalry;
        this.birthday = birthday;
    }

    /////////////////// getters
    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getMobile() {
        return this.mobile;
    }

    public String getCompany() {
        return this.company;
    }

    public double getSalary() {
        return this.salary;
    }

    public String getBirthday() {
        return this.birthday;
    }

    ////////////////////// setters
    public void setName(String name) {
        this.name = name;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}