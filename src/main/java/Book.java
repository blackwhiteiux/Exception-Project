import java.util.Objects;

public class Book {
    private String title;
    private String author;
    private int availableCopies;

    public Book(String title, String author, int availableCopies){
        this.title=title;
        this.author=author;
        this.availableCopies=availableCopies;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

    @Override
    public String toString() {
        return "| Название книги: "+getTitle()+" | Автор: "+getAuthor()+" | Доступные копии: "+getAvailableCopies()+" |";
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return availableCopies == book.availableCopies && Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, availableCopies);
    }
}
