public class Book {
    private String title; // Tiêu đề
    private String author; // Tác Giả
    private String genre; // Thể loại
    private String publishDate; // Ngày xuất bản

    private int id;

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

    public void setId(int id) {
        this.id = id;
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

    public boolean compareInfo(String query) {
        return this.getTitle().toLowerCase().equals(query) ||
                this.getAuthor().toLowerCase().equals(query) ||
                this.getGenre().toLowerCase().equals(query) ||
                this.getPublishDate().toLowerCase().equals(query);
    }
    public void showInfo(int count) {
        System.out.printf("%-10d%-15d%-30s%-30s%-30s%-30s\n", count, this.getId(), this.getTitle(), this.getAuthor(), this.getGenre(), this.getPublishDate());
    }
}