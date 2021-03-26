public class Details {
    private String name;
    private int age;
    private String sex;
    private String race;
    private String phoneNumber;
    private String height;
    private String email;

    public Details(String name, int age, String sex, String race, String phoneNumber, String height, String email) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.race = race;
        this.phoneNumber = phoneNumber;
        this.height = height;
        this.email = email;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRace() {
        return this.race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getHeight() {
        return this.height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String print(){
        String print = "\nName: " + name + "\nAge: " + age + "\nSex: " + sex + "\nRace: " + race;
        return print;
    }
}
