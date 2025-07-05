package fawry.customer;

public class Customer {
    private String ID;
    private String name;
    private String address;
    private String phoneNumber;
    private double balance;

    public Customer(String ID, String name, String address, String phoneNumber, double balance) {
        this.ID = ID;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public double getBalance() {
        return balance;
    }

    public boolean deductBalance(double amount) {
        if (balance - amount < 0) {
            return false;
        }
        else {
            balance -= amount;
            return true;
        }
    }
}
