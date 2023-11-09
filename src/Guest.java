import java.util.Scanner;

public class Guest extends LibrarySystem {
    private static final String GUEST_USERNAME = "khach";

    public static String getGuestUserName() {
        return GUEST_USERNAME;
    }

    public void pressKey(Scanner sc) {
        System.out.println("Ấn Enter để tiếp tục");
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
            System.out.printf("%-10s%-30s%-30s%-30s%-30s\n", "STT", "Tên Sách", "Tác Giả", "Thể Loại", "Ngày Xuất Bản");
            int count = 1;
            boolean check = false;
            for (Book book : bookList) {
                if (book.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                        book.getAuthor().toLowerCase().contains(query.toLowerCase()) ||
                        book.getGenre().toLowerCase().contains(query.toLowerCase()) ||
                        book.getPublishDate().contains(query)) {
                    System.out.printf("%-10d%-30s%-30s%-30s%-30s\n", count, book.getTitle(), book.getAuthor(), book.getGenre(), book.getPublishDate());
                    check = true;
                    ++count;
                }
            }
            if (!check) {

                System.out.println("Không tìm thấy sách trong thư viện");
            }
        }
    }

    public void displayBookList() {
        if (bookList.isEmpty()) {
            System.out.println("Không có cuốn sách trong thư viện");
        } else {
            System.out.println("\nDanh Sách Sách: ");
            System.out.printf("%-10s%-30s%-30s%-30s%-30s\n", "STT", "Tên Sách", "Tác Giả", "Thể Loại", "Ngày Xuất Bản");
            int count = 1;
            for (Book book : bookList) {
                System.out.printf("%-10d%-30s%-30s%-30s%-30s\n", count, book.getTitle(), book.getAuthor(), book.getGenre(), book.getPublishDate());
                ++count;
            }
        }
    }
}