public class Victim {
    private String name;
    private int age;
    private String sex;
    private String race;
    private String details;

    public Victim(String name, int age, String sex, String race, String details) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.race = race;
        this.details = details;
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

    public String getDetails() {
        return this.details;
    }

    public void setDetails(String details) {
        this.details = details;
    }


}
