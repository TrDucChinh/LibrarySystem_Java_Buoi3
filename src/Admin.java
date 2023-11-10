import java.util.Scanner;

public class Admin extends Guest {
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin";

    public static String getAdminUserName() {
        return ADMIN_USERNAME;
    }

    public static String getAdminPassWord() {
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
                    super.pressKey(sc);
                    break;
                case 2:
                    deleteBook(sc);
                    super.pressKey(sc);
                    break;
                case 3:
                    updateBook(sc);
                    super.pressKey(sc);
                    break;
                case 4:
                    super.searchBook(sc);
                    super.pressKey(sc);
                    break;
                case 5:
                    super.displayBookList();
                    super.pressKey(sc);
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
        System.out.print("\nNhập số lượng sách muốn thêm: ");
        int numberOfBook = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < numberOfBook; ++i) {
            int id = (int) (Math.random() * 10000 + 1);
            System.out.print("Tên sách: ");
            String title = sc.nextLine();
            System.out.print("Tác giả: ");
            String author = sc.nextLine();
            System.out.print("Thể loại: ");
            String genre = sc.nextLine();
            System.out.print("Ngày xuất bản: ");
            String publishDate = sc.nextLine();
            Book newBook = new Book(id, title, author, genre, publishDate);
            bookList.add(newBook);
            System.out.println("Thêm sách thành công!");
            if (i < numberOfBook - 1) {
                System.out.println("\nNhập thông tin cuốn sách tiếp theo");
            } else if (i == numberOfBook - 1){
                System.out.println("Thêm " + numberOfBook + " thành công!");
            }
        }

    }

    public void deleteBook(Scanner sc) {
        super.displayBookList();
        System.out.print("\nNhập tên sách muốn xóa: ");
        String title = sc.nextLine();
        if(Book.existBook(title)){
            System.out.println("Không tìm thấy sách trong thư viện");
        } else {
            Guest.print();
            int countBook = 1;
            for (Book book : bookList) {
                if (book.compareTitle(title)) {
                    book.showBook(countBook);
                    ++countBook;
                }
            }
            System.out.print("\nNhập ID sách muốn xóa: ");
            int id = Integer.parseInt(sc.nextLine());
            for (Book book : bookList){
                if (book.getId() == id){
                    bookList.remove(book);
                    System.out.println("Xóa sách thành công");
                    return;
                }
            }
        }
    }

    //Em muốn update theo id vì có thể có tên trùng nma chưa biết fix sao
    public void updateBook(Scanner sc) {
        super.displayBookList();
        System.out.print("\nNhập tên sách muốn cập nhật: ");
        String title = sc.nextLine();
        if(Book.existBook(title)) {
            System.out.println("Không tìm thấy sách trong thư viện");
        } else {
            Guest.print();
            int countBook = 1;
            for (Book book : bookList) {
                if (book.compareTitle(title)) {
                    book.showBook(countBook);
                    ++countBook;
                }
            }
            System.out.print("\nNhập ID sách muốn cập nhật: ");
            int id = Integer.parseInt(sc.nextLine());
            System.out.println("\nChọn mục cần sửa: ");
            System.out.println("1. Tên sách");
            System.out.println("2. Tác Giả");
            System.out.println("3. Thể Loại");
            System.out.println("4. Ngày Xuất Bản");
            System.out.print("Nhập lựa chọn: ");
            byte choice = Byte.parseByte(sc.nextLine());
            switch (choice) {
                case 1:
                    for (Book book : bookList) {
                        if (book.getId() == id) {
                            System.out.print("Tên sách: ");
                            book.setTitle(sc.nextLine());
                            System.out.println("Cập nhật tên sách thành công!");
                            return;
                        }
                    }
                    break;
                case 2:
                    for (Book book : bookList) {
                        if (book.getId() == id) {
                            System.out.print("Tên tác giả: ");
                            book.setAuthor(sc.nextLine());
                            System.out.println("Cập nhật tên tác giả thành công!");
                            return;
                        }
                    }
                    break;
                case 3:
                    for (Book book : bookList) {
                        if (book.getId() == id) {
                            System.out.print("Thể loại: ");
                            book.setGenre(sc.nextLine());
                            System.out.println("Cập nhật thể loại thành công!");
                            return;
                        }
                    }
                    break;
                case 4:
                    for (Book book : bookList) {
                        if (book.getId() == id) {
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
        }
    }
}
