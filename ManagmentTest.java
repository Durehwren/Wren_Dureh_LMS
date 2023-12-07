import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

class ManagmentTest {

    ArrayList<Book> LMS = new ArrayList<Book>();
    ArrayList<Book> testArray = new ArrayList<Book>();

    private void showLMS(){
        for (Book book : LMS){
            System.out.println(book.getiD());
            System.out.println(book.getTitle());
            System.out.println(book.getAuthor());
            System.out.println(book.isCheckedOut());
            System.out.println(book.getDueDate());
            System.out.println("-----------------");
        }
        System.out.println();
        System.out.println();
        System.out.println();
    }

    private void removeBookByID(String id){
        //System.out.println(Book.getiD());
        LMS.removeIf(book -> book.getiD().equals(id));
    }

    /*
     * method: removeBookByTitle
     * parameters: a book id value as a string
     * return: none
     * a method to remove a book from the LMS arraylist by its ID value
     */
    private void removeBookByTitle(String title){
        //System.out.println(Book.getTitle());
        LMS.removeIf(book -> book.getTitle().equals(title));
    }

    public void CheckOut(String Title) {

        for (Book book : LMS){
            if (book.getTitle().equals(Title)) {
                book.setCheckedOut(true);
                book.setDueDate();
            }

        }
    }

    public void CheckIn(String Title) {

        for (Book book : LMS){
            if (book.getTitle().equals(Title)){
                book.setCheckedOut(false);
                book.resetDueDate();
            }
        }
    }

    @org.junit.jupiter.api.BeforeEach
    void setUp() {




    }


    @org.junit.jupiter.api.Test
    @DisplayName("verifies that books can be added")
    void addbook() {

        Book book1 =new Book("1", "Jujustu Kiasen", "Gojo", false, null );

        LMS.add(book1);

        showLMS();

        Book result = LMS.get(0);

        Book expect = book1;

        assertArrayEquals(new Book[]{expect}, new Book[]{result});
    }

    @org.junit.jupiter.api.Test
    @DisplayName("verifies that a book can be removed from the database by barcode or title")
    void removebyboth() {

        Book book1 =new Book("1", "Jujustu Kiasen", "Gojo", false, null );

        LMS.add(book1);

        Book book2 =new Book("2", "SAO", "Kirito", false, null );

        LMS.add(book2);

        Book book3 =new Book("3", "AOT", "Eren", false, null );

        LMS.add(book3);
        testArray.add(book3);

        showLMS();

        removeBookByID("1");

        System.out.println("LMS after removing by ID");
        showLMS();

        removeBookByTitle("SAO");

        System.out.println("LMS after removing by Title");
        showLMS();

        assertArrayEquals(LMS.toArray(),testArray.toArray());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("verifies that a book can be checked out.  If so, the due date is no longer \"null\".")
    void checkoutduedate() {

        Book book1 =new Book("1", "Jujutsu Kiasen", "Gojo", false, null );

        LMS.add(book1);

        Book book2 =new Book("2", "SAO", "Kirito", false, null );

        LMS.add(book2);

        Book book3 =new Book("3", "AOT", "Eren", false, null );

        LMS.add(book3);

        showLMS();

        CheckOut("Jujutsu Kiasen");

        System.out.println("After checking out Jujustu Kaisen.");
        showLMS();

        assertFalse(Boolean.parseBoolean(String.valueOf(LMS.get(2))), String.valueOf(book3));

    }

    @org.junit.jupiter.api.Test
    @DisplayName("A unit test correctly verifies that a book can be checked in. If so, the due date is \"null\"")
    void checkinduedate() {

        Book book1 =new Book("1", "Jujutsu Kiasen", "Gojo", false, null );

        LMS.add(book1);

        Book book2 =new Book("2", "SAO", "Kirito", false, null );

        LMS.add(book2);

        Book book3 =new Book("3", "AOT", "Eren", false, null );

        LMS.add(book3);

        CheckOut("Jujutsu Kiasen");

        showLMS();

        CheckIn("Jujutsu Kiasen");

        System.out.println("After checking in Jujutsu Kaisen");
        showLMS();

        assertArrayEquals(String.valueOf(LMS.get(0)).toCharArray(), String.valueOf(book1).toCharArray());

    }
}
