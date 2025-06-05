package MapPractice;

import java.util.*;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Scanner;
//import java.util.Set;

public class ContactList {
    private static Map<String, Contact> contactList = new HashMap<>();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Contact Management ===");
            System.out.println("1. Thêm liên lạc");
            System.out.println("2. Sửa liên lạc");
            System.out.println("3. Xóa liên lạc");
            System.out.println("4. Tìm kiếm liên lạc");
            System.out.println("5. Exit");
            System.out.println("Chọn chức năng: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    editContact();
                    break;
                case 3:
                    deleteContact();
                    break;
                case 4:
                    searchContact();
                    break;
                case 5:
                    System.out.println("Thoát chương trình!");
                    break;
                default:
                    System.out.println("Chức năng không hợp lệ!");
            }
        } while (choice != 0);

    }

    private static void addContact() {
        System.out.println("Hay nhap so dien thoai: ");
        String phoneNumber = input.nextLine();
        System.out.println("Hay nhap ho ten: ");
        String fullName = input.nextLine();
        System.out.println("Hay nhap email: ");
        String email = input.nextLine();

        contactList.put(phoneNumber,new Contact(fullName,email));
        System.out.println("Contact added successfully!");
    }

    private static void searchContact(){
        System.out.println("Nhập từ khóa: ");
        String keyWord = input.nextLine().toLowerCase();

        Set<Map.Entry<String, Contact>> entries = contactList.entrySet();

        boolean found = false;
        for (Map.Entry<String, Contact> entry : entries) {
            String phoneNumber = entry.getKey();
            Contact contact = entry.getValue();

            if (phoneNumber.contains(keyWord) || contact.getFullName().toLowerCase().contains(keyWord)
                    || contact.getEmail().toLowerCase().contains(keyWord)) {
                System.out.println("Kết quả tìm kiếm: " + phoneNumber + " - " + contact);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không có liên hệ này!");
        }
    }

    private static void deleteContact() {
        System.out.println("Nhập liên hệ cần xóa: ");
        String deleteKey = input.nextLine().toLowerCase();

        boolean found = false;

        for (Map.Entry<String, Contact> remove : contactList.entrySet()) {
            String phoneNumber = remove.getKey();
            Contact contact = remove.getValue();

            if (phoneNumber.contains(deleteKey) || contact.getFullName().toLowerCase().contains(deleteKey)
                    || contact.getEmail().toLowerCase().contains(deleteKey)) {
                contactList.remove(phoneNumber);
                System.out.println("Đã xóa liên hệ này!");
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không có liên hệ này!");
        }
    }

    private static void editContact() {
        System.out.println("Hãy nhập liên hệ cần sửa: ");
        String keyWord = input.nextLine().toLowerCase();

        Contact contact = contactList.get(keyWord);
        if (contact == null) {
            System.out.println("Không tìm thấy liên hệ này!");
        }

        System.out.print("Nhập họ tên mới: ");
        String name = input.nextLine();
        if (!name.trim().isEmpty()) {
            contact.setFullName(name);
        }

        System.out.print("Nhập email mới: ");
        String email = input.nextLine();
        if (!email.trim().isEmpty()) {
            contact.setEmail(email);
        }

        System.out.println("Liên lạc đã được sửa thành công!");
    }
}
