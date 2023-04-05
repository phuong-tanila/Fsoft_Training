package fa.training.problem03.models;

public class Customer {
    private int id;
    private String fullname;
    private String address;
    private String phonenumber;
    private int age;

    public Customer () {

    }

    public Customer(int id, String fullname, String address, String phonenumber, int age) {
        this.id = id;
        this.fullname = fullname;
        this.address = address;
        this.phonenumber = phonenumber;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", address='" + address + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", age=" + age +
                '}';
    }

    public void save(Customer customer1) {
    }
}
