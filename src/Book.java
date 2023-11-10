public class Book extends LibrarySystem{
    private String title; // Tiêu đề
    private String author; // Tác Giả
    private String genre; // Thể loại
    private String publishDate; // Ngày xuất bản

    private final int id;

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public int getId() {
        return id;
    }
    public Book(int id, String title, String author, String genre, String publishDate) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publishDate = publishDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public boolean searchInfo(String query) {
        return this.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                this.getAuthor().toLowerCase().contains(query.toLowerCase()) ||
                this.getGenre().toLowerCase().contains(query.toLowerCase()) ||
                this.getPublishDate().contains(query);
    }

    public boolean compareTitle(String query) {
        return this.getTitle().equals(query);

    }
//    public void showBook(int count){
//        this.showInfo(count);
//    }
    public static boolean existBook(String query) {
        boolean checkBook = false;
        for (Book book : bookList) {
            if (book.compareTitle(query)) {
                checkBook = true;
            }
        }
        return !checkBook;
    }
    public void showInfo(int count) {
        System.out.printf("%-10d%-15d%-30s%-30s%-30s%-30s\n", count, this.getId(), this.getTitle(), this.getAuthor(), this.getGenre(), this.getPublishDate());
    }
}