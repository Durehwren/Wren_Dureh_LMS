//Dureh Wren,CEN 3024C, OCT 1st,2023
//Software Development I
/* The Library class has not been used yet.*/

import java.util.ArrayList;

public class Library {
    //Creation of LMS array list
    static ArrayList<Book> LMS = new ArrayList<Book>();

    /*
     * method: addBook
     * parameters: a book object
     * return: none
     * an alternate method to add a book to LMS arraylist
     */
    private void addBook(Book book){
        LMS.add(book);
    }

    /*
     * method: showLMS
     * parameters: none
     * return: none
     * a method to print all the books in the LMS arraylist
     */
    public static void showLMS(){
        for (Book book : LMS){
            System.out.println(book.getiD());
            System.out.println(book.getTitle());
            System.out.println(book.getAuthor());
            System.out.println(book.isCheckedOut());
            System.out.println(book.getDueDate());
            System.out.println("-----------------");
        }
    }

}

