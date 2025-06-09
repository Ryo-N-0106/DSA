package MoPhongGiaoDichNganHang;

public class Counter {
    private int id;
    private boolean isBusy;
    private Customer currentCustomer;

    public Counter(int id) {
        this.id = id;
        this.isBusy = true; // Mặc định quầy bận
        this.currentCustomer = null;
    }

    public int getId() {
        return id;
    }

    public boolean isBusy() {
        return isBusy;
    }

    public void setBusy(boolean busy) {
        this.isBusy = busy;
    }

    public Customer getCurrentCustomer() {
        return currentCustomer;
    }

    public void setCurrentCustomer(Customer customer) {
        this.currentCustomer = customer;
        this.isBusy = (customer != null);
    }

    @Override
    public String toString() {
        return "Quầy " + id + ": " + (isBusy ? "Bận (" + currentCustomer + ")" : "Rảnh");
    }
}
