import java.util.Scanner;

public class Guest extends LibrarySystem {
    private static final String GUEST_USERNAME = "khach";

    public static String getGuestUserName() {
        return GUEST_USERNAME;
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
                    break;
                case 2:
                    displayBookList();
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
            int count = 1;
            boolean check = false;
            for (Book book : bookList) {
                if (book.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                        book.getAuthor().toLowerCase().contains(query.toLowerCase()) ||
                        book.getGenre().toLowerCase().contains(query.toLowerCase()) ||
                        book.getPublishDate().contains(query)) {
                    System.out.println(count +  ". Tên Sách: " + book.getTitle() + " | Tác Giả: " + book.getAuthor() +
                            " | Thể Loại: " + book.getGenre() + " | Ngày Xuất Bản: " + book.getPublishDate());
                    //System.out.printf("{} {} {} {}\n", book.getTitle(), book.getAuthor(), book.getGenre(), book.getPublishDate());
                    check = true;
                    ++count;
                }
            }
            if (!check){
                System.out.println("Không tìm thấy sách trong thư viện");
            }
        }
    }

    public void displayBookList() {

        if (bookList.isEmpty()) {
            System.out.println("Không có cuốn sách trong thư viện");
        } else {
            System.out.println("\nDanh Sách Sách: ");
            int count = 1;
            for (Book book : bookList) {
                System.out.println(count + ". Tên sách: " + book.getTitle() + " | Tác Giả: " + book.getAuthor() +
                        " | Thể Loại: " + book.getGenre() + " | Ngày Xuất Bản: " + book.getPublishDate());
               // System.out.printf("{} {} {} {}\n", book.getTitle(), book.getAuthor(), book.getGenre(), book.getPublishDate());
                ++count;
            }
        }
    }
}