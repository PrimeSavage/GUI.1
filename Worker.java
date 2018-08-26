package sample;

public class Worker {
    private int ID;
    private String name;
    private String surname;
    private Double payment;

    Worker(int ID, String name, String surname, double payment){
        this.ID = ID;
        this.name = name;
        this.surname = surname;
        this.payment = payment;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Double getPayment() {
        return payment;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }
}
