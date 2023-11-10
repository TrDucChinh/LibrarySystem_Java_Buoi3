import java.util.Scanner;

public class Guest extends LibrarySystem {
    private static final String GUEST_USERNAME = "khach";

    public static String getGuestUserName() {
        return GUEST_USERNAME;
    }

    public static void print() {
        System.out.printf("%-10s%-15s%-30s%-30s%-30s%-30s\n", "STT", "ID", "Tên Sách", "Tác Giả", "Thể Loại", "Ngày Xuất Bản");
    }

    public void pressKey(Scanner sc) {
        System.out.println("\nẤn Enter để tiếp tục");
        sc.nextLine();
    }

    public void guestActions(Scanner sc) {
        while (true) {
            System.out.println("\nGuest Menu:");
            System.out.println("1. Tìm kiếm sách");
            System.out.println("2. Xem danh sách sách");
            System.out.println("3. Thoát");

            System.out.print("Nhập lựa chọn: ");
            byte choice = sc.nextByte();
            sc.nextLine();
            switch (choice) {
                case 1:
                    searchBook(sc);
                    pressKey(sc);
                    break;
                case 2:
                    displayBookList();
                    pressKey(sc);
                    break;
                case 3:
                    System.out.println("Bạn đã thoát khỏi chế độ khách");
                    System.out.println("Cảm ơn bạn đã sử dụng hệ thống thư viện của mình <3");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        }
    }

    public void searchBook(Scanner sc) {
        if (bookList.isEmpty()) {
            System.out.println("Không có cuốn sách nào trong thư viện");
        } else {
            System.out.print("Nhập truy vấn: ");
            String query = sc.nextLine();
            System.out.println("Kết quả tìm kiếm: ");
            boolean checkBook = false;
            for (Book book : bookList) {
                if (book.searchInfo(query)) {
                    checkBook = true;
                }
            }
            if (!checkBook) {
                System.out.println("Không tìm thấy sách trong thư viện");
            } else {
                int count = 1;
                print();
                for (Book book : bookList) {
                    if (book.searchInfo(query)) {
                        book.showInfo(count);
                        ++count;
                    }
                }
            }
        }
    }

    public void displayBookList() {
        if (bookList.isEmpty()) {
            System.out.println("Không có cuốn sách trong thư viện");
        } else {
            System.out.println("\nDanh Sách Sách: ");
            print();
            int count = 1;
            for (Book book : bookList) {
                book.showInfo(count);
                ++count;
            }
        }
    }
}