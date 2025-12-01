import java.util.ArrayList;
import java.util.List;

public class Library {
    private final List<Book> catalog=new ArrayList<>();

    public void addBook(String title, String author, int availableCopies){
        Book book=new Book(title, author, availableCopies);
        catalog.add(book);
        System.out.println("Книга успешно добавлена!");
    }

    public void takeBook(String title){
        for (Book book:catalog){
            if(book.getTitle().equals(title)){
                if(book.getAvailableCopies()>0){
                    book.setAvailableCopies(book.getAvailableCopies()-1);
                    System.out.println("Книга "+title+" успешно выдана!");
                    return;
                } else {
                    throw new NoAvailableCopiesException("Доступных копий книги '"+title+"' нет в наличии.");
                }
            }
        }
        throw new ItemNotFoundException("Книги с названием "+title+" не найдено.");
    }

    public void returnBook(String title){
        for (Book book:catalog){
            if(book.getTitle().equals(title)){
                book.setAvailableCopies(book.getAvailableCopies()+1);
                System.out.println("Вы вернули книгу "+title);
                return;
            }
        }
        throw new ItemNotFoundException("Книги с названием "+title+" не найдено.");
    }
    public List<Book> getAllBooks() {
        return new ArrayList<>(catalog);
    }
}


