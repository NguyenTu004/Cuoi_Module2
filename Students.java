public class Students {
    private String id;
    private String name;
    private int age;
    private String gender;
    private String address;
    private double mediumScore;

    public Students() {
    }

    public Students(String id, String name, int age, String gender, String address, double mediumScore) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.mediumScore = mediumScore;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getMediumScore() {
        return mediumScore;
    }

    public void setMediumScore(double mediumScore) {
        this.mediumScore = mediumScore;
    }

    @Override
    public String toString() {
        return "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", mediumScore=" + mediumScore;
    }
    public String displayCSV() {
        return id + "," +name + "," +age + "," +gender + "," +address+","+mediumScore;
    }
}
