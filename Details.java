package CrimeManagementSystem;

public class Details {
    private String name;
    private int age;
    private char sex;
    private String race;

    public Details() {
        name = "";
        age = 0;
        sex = "";
        race = "";
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

    public char getSex() {
        return this.sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getRace() {
        return this.race;
    }

    public void setRace(String race) {
        this.race = race;
    }


}
