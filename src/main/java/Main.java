import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library=new Library();
        Scanner scanner=new Scanner(System.in);
        int choose=0;
        int availableCopies=0;
        boolean validAvailableCopies=false;

        while (true){
            System.out.println("1. Вывести каталог.");
            System.out.println("2. Добавить книгу.");
            System.out.println("3. Выдать книгу.");
            System.out.println("4. Вернуть книгу.");
            System.out.println("5. Выйти из приложения.");

            try {
                choose=scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e){
                System.out.println("Некорректный ввод, попробуйте еще раз.");
                scanner.nextLine();
            }

            switch (choose){
                case 1:
                    List<Book> books=library.getAllBooks();
                    if(books.isEmpty()){
                        System.out.println("Каталог пуст.");
                    } else {
                        System.out.println("Каталог книг:");
                        for(Book book : books){
                            System.out.println(book);
                        }
                    }
                    break;
                case 2:
                    System.out.println("Введите название: ");
                    String title=scanner.nextLine();
                    System.out.println("Введите автора: ");
                    String author=scanner.nextLine();
                    while (!validAvailableCopies) {
                        System.out.println("Введите колчиство копий: ");
                        try {
                            availableCopies = scanner.nextInt();
                            validAvailableCopies = true;
                        } catch (InputMismatchException e) {
                            System.out.println("Введите число!");
                            scanner.nextLine();
                        }
                    }
                    library.addBook(title, author, availableCopies);
                    validAvailableCopies=false;
                    break;
                case 3:
                    System.out.println("Введите название: ");
                    title=scanner.nextLine();
                    try {
                        library.takeBook(title);
                    } catch ( ItemNotFoundException e){
                        System.out.println("Ошибка: "+e.getMessage());
                    } catch (NoAvailableCopiesException e){
                        System.out.println("Oшибка: "+e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Введите название: ");
                    title=scanner.nextLine();
                    try {
                        library.returnBook(title);
                    } catch (ItemNotFoundException e){
                        System.out.println("Ошибка: "+e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Спасибо за использование программы!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Введите цифру от 1 до 5.");
            }
        }
    }
}
