public class Book {
    private String title; // Tiêu đề
    private String author; // Tác Giả
    private String genre; // Thể loại
    private String publishDate; // Ngày xuất bản

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

    public Book(String title, String author, String genre, String publishDate) {
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
    public boolean compareInfo(String query){
        return this.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                this.getAuthor().toLowerCase().contains(query.toLowerCase()) ||
                this.getGenre().toLowerCase().contains(query.toLowerCase()) ||
                this.getPublishDate().contains(query);
    }
}