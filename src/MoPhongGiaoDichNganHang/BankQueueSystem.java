package MoPhongGiaoDichNganHang;

import java.util.LinkedList;
import java.util.Scanner;

public class BankQueueSystem {
    private static LinkedList<Customer> queue = new LinkedList<>();
    private static Counter[] counters = new Counter[5];
    private static int nextTicketNumber = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Khởi tạo 5 quầy giao dịch, mặc định bận
        for (int i = 0; i < 5; i++) {
            counters[i] = new Counter(i + 1);
        }

        while (true) {
            System.out.println("\n=== HỆ THỐNG QUẢN LÝ HÀNG ĐỢI NGÂN HÀNG ===");
            System.out.println("1. Thêm 10 khách hàng mới");
            System.out.println("2. Quầy hoàn tất phục vụ");
            System.out.println("3. Hiển thị hàng đợi hiện tại");
            System.out.println("4. Hiển thị trạng thái các quầy");
            System.out.println("5. Thoát");
            System.out.print("Chọn tùy chọn (1-5): ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số từ 1 đến 5!");
                continue;
            }

            switch (choice) {
                case 1:
                    addCustomers();
                    break;
                case 2:
                    processCounter(scanner);
                    break;
                case 3:
                    displayQueue();
                    break;
                case 4:
                    displayCounters();
                    break;
                case 5:
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Tùy chọn không hợp lệ! Vui lòng chọn lại.");
            }
        }
    }

    // Thêm 10 khách hàng mới
    private static void addCustomers() {
        for (int i = 0; i < 10; i++) {
            String name = "Khách hàng " + nextTicketNumber;
            queue.add(new Customer(nextTicketNumber, name));
            System.out.println("Đã thêm: " + queue.getLast());
            nextTicketNumber++;
        }
        assignCustomersToFreeCounters();
    }

    // Gọi khách tiếp theo khi quầy rảnh
    private static void processCounter(Scanner scanner) {
        System.out.print("Nhập số quầy (1-5): ");
        int counterId;
        try {
            counterId = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Vui lòng nhập số quầy hợp lệ!");
            return;
        }

        if (counterId < 1 || counterId > 5) {
            System.out.println("Quầy không tồn tại! Vui lòng nhập số từ 1 đến 5.");
            return;
        }

        Counter counter = counters[counterId - 1];
        if (!counter.isBusy()) {
            System.out.println("Quầy " + counterId + " đã rảnh!");
        } else {
            System.out.println("Quầy " + counterId + " hoàn tất phục vụ " + counter.getCurrentCustomer());
            counter.setCurrentCustomer(null);
            assignCustomersToFreeCounters();
        }
    }

    // Gán khách hàng cho các quầy rảnh
    private static void assignCustomersToFreeCounters() {
        for (Counter counter : counters) {
            if (!counter.isBusy() && !queue.isEmpty()) {
                Customer nextCustomer = queue.removeFirst();
                counter.setCurrentCustomer(nextCustomer);
                System.out.println("Quầy " + counter.getId() + " đang phục vụ: " + nextCustomer);
            }
        }
    }

    // Hiển thị hàng đợi hiện tại
    private static void displayQueue() {
        if (queue.isEmpty()) {
            System.out.println("Hàng đợi trống.");
        } else {
            System.out.println("Hàng đợi hiện tại:");
            for (Customer customer : queue) {
                System.out.println(customer);
            }
        }
    }

    // Hiển thị trạng thái các quầy
    private static void displayCounters() {
        System.out.println("Trạng thái các quầy:");
        for (Counter counter : counters) {
            System.out.println(counter);
        }
    }
}
