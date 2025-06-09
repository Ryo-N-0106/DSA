package MoPhongGiaoDichNganHang;

public class Customer {
    private int ticketNumber;
    private String name;

    public Customer(int ticketNumber, String name) {
        this.ticketNumber = ticketNumber;
        this.name = name;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Số thứ tự: " + ticketNumber + ", Tên: " + name;
    }
}
