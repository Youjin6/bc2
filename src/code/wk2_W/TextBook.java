package code.wk2_W;

/**
 * @author youjin
 */
public class TextBook {
    private String title;
    private String author;
    private String publisher;

    public TextBook(String title, String author, String publisher) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
    }

    public TextBook(TextBook object2) {
        title = object2.title;
        author = object2.author;
        publisher = object2.publisher;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        String str = "TextBook{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
        return str;
    }
}
