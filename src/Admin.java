import java.util.Scanner;

public class Admin extends Guest {
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin";

    public static String getADMIN_USERNAME() {
        return ADMIN_USERNAME;
    }

    public static String getADMIN_PASSWORD() {
        return ADMIN_PASSWORD;
    }
    public void adminActions(Scanner sc) {
        while (true) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Thêm sách");
            System.out.println("2. Xóa sách");
            System.out.println("3. Cập nhật sách");
            System.out.println("4. Tìm kiếm sách");
            System.out.println("5. Xem danh sách sách");
            System.out.println("6. Thoát");
            System.out.print("Nhập lựa chọn: ");
            byte choice = sc.nextByte();
            sc.nextLine();
            switch (choice) {
                case 1:
                    this.addBook(sc);
                    break;
                case 2:
                    deleteBook(sc);
                    break;
                case 3:
                    updateBook(sc);
                    break;
                case 4:
                    super.searchBook(sc);
                    break;
                case 5:
                    super.displayBookList();
                    break;
                case 6:
                    System.out.println("Thoát chế độ admin!!");
                    guestActions(sc);
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        }

    }
    public void addBook(Scanner sc) {
        System.out.print("Tên sách: ");
        String title = sc.nextLine();
        System.out.print("Tác giả: ");
        String author = sc.nextLine();
        System.out.print("Thể loại: ");
        String genre = sc.nextLine();
        System.out.print("Ngày xuất bản: ");
        String publishDate = sc.nextLine();
        Book newBook = new Book(title, author, genre, publishDate);
        bookList.add(newBook);
        System.out.println("Thêm sách thành công!");
    }

    public void deleteBook(Scanner sc) {
        System.out.print("Nhập tên sách muốn xóa: ");
        String title = sc.nextLine();
        for (Book book : bookList){
            if (book.getTitle().toLowerCase().equals(title)){
                bookList.remove(book);
                System.out.println("Xóa sách thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy sách trong thư viện");

    }

    public void updateBook(Scanner sc) {
        System.out.print("Nhập tên sách muốn cập nhật: ");
        String title = sc.nextLine();
        System.out.println("\n1. Tên sách");
        System.out.println("2. Tác Giả");
        System.out.println("3. Thể Loại");
        System.out.println("4. Ngày Xuất Bản");
        System.out.print("Nhập mục cần sửa: ");
        byte choice = sc.nextByte();
        sc.nextLine();
        switch (choice){
            case 1:
                for (Book book : bookList){
                    if (book.getTitle().toLowerCase().equals(title)){
                        System.out.print("Tên sách: ");
                        book.setTitle(sc.nextLine());
                        System.out.println("Cập nhật tên sách thành công!");
                        return;
                    }
                }
                break;
            case 2:
                for (Book book : bookList){
                    if (book.getTitle().toLowerCase().equals(title)){
                        System.out.print("Tên tác giả: ");
                        book.setAuthor(sc.nextLine());
                        System.out.println("Cập nhật tên tác giả thành công!");
                        return;
                    }
                }
                break;
            case 3:
                for (Book book : bookList){
                    if (book.getTitle().toLowerCase().equals(title)){
                        System.out.print("Thể loại: ");
                        book.setGenre(sc.nextLine());
                        System.out.println("Cập nhật thể loại thành công!");
                        return;
                    }
                }
                break;
            case 4:
                for (Book book : bookList){
                    if (book.getTitle().toLowerCase().equals(title)){
                        System.out.print("Ngày xuất bản: ");
                        book.setPublishDate(sc.nextLine());
                        System.out.println("Cập nhật ngày xuất bản thành công!");
                        return;
                    }
                }
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ");
        }
        for (Book book : bookList){
            if (book.getTitle().toLowerCase().equals(title)){

                System.out.print("Tác giả: ");
                book.setAuthor(sc.nextLine());
                System.out.print("Thể loại: ");
                book.setGenre(sc.nextLine());
                System.out.print("Ngày xuất bản: ");
                book.setPublishDate(sc.nextLine());
                return;
            }
        }
        System.out.println("Không tìm thấy sách trong thư viện");
    }
}
