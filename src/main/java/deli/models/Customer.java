package deli.models;

public class Customer {
    private String name;
    private String phone;
    private String address;

    public Customer(String name, String phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public String getInfo() {
        return name + " | " + phone + "\n" + address;
    }
}