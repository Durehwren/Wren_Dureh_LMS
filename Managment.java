//Dureh Wren,CEN 3024C, OCT 1st,2023
//Software Development I
/* The Management class is what manages the entire program as a whole pulling from other classes and executing the main method
   as well as doing all the storing, and printing*/

import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Management {

    //Creation of LMS array list
    private static final ArrayList<Book> LMS = new ArrayList<Book>();


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
     * method: removeBookByID
     * parameters: a book id value as a string
     * return: none
     * a method to remove a book from the LMS arraylist by its ID value
     */
    private static void removeBookByID(String id){
        //System.out.println(Book.getiD());
        LMS.removeIf(book -> book.getiD().equals(id));
    }

    /*
     * method: removeBookByTitle
     * parameters: a book id value as a string
     * return: none
     * a method to remove a book from the LMS arraylist by its ID value
     */
    private static void removeBookByTitle(String title){
        //System.out.println(Book.getTitle());
        LMS.removeIf(book -> book.getTitle().equals(title));
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

    /*
     * method: CheckOut
     * parameters: Title
     * return: none
     * a method to set the book to checked out and generate a due date.
     */
    public static void CheckOut(String Title) {

        for (Book book : LMS){
            if (book.getTitle().equals(Title)) {
                book.setCheckedOut(true);
                book.setDueDate();
            }

        }
    }


    /*
     * method: CheckIn
     * parameters: Title
     * return: none
     * a method to set the book to checked in and set due date to null.
     */
    public static void CheckIn(String Title) {

        for (Book book : LMS){
            if (book.getTitle().equals(Title)){
                book.setCheckedOut(false);
                book.resetDueDate();
            }
        }
    }

    public static void main(String[] args) {

        //1 Ask for file name, scan it, open provided file path
        //  Add book in file by scanning next line and applying values to three holder variables
        boolean checkLoop = true;
        String line = "";

        Scanner scan = new Scanner(System.in);

        System.out.println("Please Enter the file path of the document.");

        String filePath = scan.nextLine();
        System.out.println(filePath);
        System.out.println("Is this the file path?");
        System.out.println("Y or N ");

        String fileCheck = scan.nextLine();


        while (checkLoop)
            if ((fileCheck.equals("y")) || (fileCheck.equals("Y")) || (fileCheck.equals("yes")) || (fileCheck.equals("Yes"))) {
                System.out.println("Great!");
                checkLoop = false;
            }
            else {
                System.out.println("Please reenter the file path of the document.");

                filePath = scan.nextLine();
                System.out.println(filePath);
                System.out.println("Is this the file path?");
                System.out.println("Y or N ");
                fileCheck = scan.nextLine();
            }

        // This creates a buffer reader to read through the comma seperated code
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath)); //"C:\Users\dureh\OneDrive - Knights - University of Central Florida\Desktop\LMStest.txt"

            // a loop to read each line of the comma sepereated data and add it as a book object to the LMS arraylist
            while((line = br.readLine()) != null) {
                String[] reader = line.split(",");
                //System.out.println("Book - ID = " + reader[0] + ", Title = " + reader[1] + ", Author = " + reader[2]);
                Book book =new Book(reader[0], reader[1], reader[2], false, null );
                LMS.add(book);
            }
        } catch (IOException var4) {
            var4.printStackTrace();
        }

        showLMS();




        //2 print that the database is printing
        //  print database

        System.out.println("Printing Library Managment Database.");
        showLMS();

        //3 ask for barcode, scan it, remove book from database
        //print a confirmation of deletion, reprint database

        System.out.println("Would you like to remove a book by barcode?");

        String removalCheck = scan.nextLine();

        if ((removalCheck.equals("y")) || (removalCheck.equals("Y")) || (removalCheck.equals("yes")) || (removalCheck.equals("Yes"))) {
            System.out.println("Please enter the barcode of the book you would like to remove.");
            String removalID = scan.nextLine();
            removeBookByID(removalID);
            System.out.println("ID " + removalID + " has been removed.");
            showLMS();
        }
        else {
            System.out.println("Ok.");
        }


        //4 Ask for Title, scan it, remove book with title
        //print a confirmation of deletion, reprint database

        System.out.println("Would you like to remove a book title?");

        removalCheck = scan.nextLine();

        if ((removalCheck.equals("y")) || (removalCheck.equals("Y")) || (removalCheck.equals("yes")) || (removalCheck.equals("Yes"))) {
            System.out.println("Please enter the title of the book you would like to remove. (Please capitalize the proper letters)");
            String removaltitle = scan.nextLine();
            removeBookByTitle(removaltitle);
            System.out.println("Title " + removaltitle + " has been removed.");
            showLMS();
        }
        else {
            System.out.println("Ok.");
        }

        //5 Ask the user for a title to check out.
        // Check out the book, print a confirmation message,  re-print the contents of the database to the screen.

        System.out.println("Would you like to check out a book?");

        removalCheck = scan.nextLine();

        if ((removalCheck.equals("y")) || (removalCheck.equals("Y")) || (removalCheck.equals("yes")) || (removalCheck.equals("Yes"))) {
            System.out.println("Please enter the Title of the book you would like to check out. (Please capitalize the proper letters)");
            String checkOutTitle = scan.nextLine();
            CheckOut(checkOutTitle);
            System.out.println("Title " + checkOutTitle + " has been checked out.");
            showLMS();

        }
        else {
            System.out.println("Ok.");
        }

        //Ask the user for a title to check in.
        // Check in the book, print a confirmation message, and re-print the contents of the database to the screen.

        System.out.println("Would you like to check in a book?");

        removalCheck = scan.nextLine();

        if ((removalCheck.equals("y")) || (removalCheck.equals("Y")) || (removalCheck.equals("yes")) || (removalCheck.equals("Yes"))) {
            System.out.println("Please enter the Title of the book you would like to check out. (Please capitalize the proper letters)");
            String checkInTitle = scan.nextLine();
            CheckIn(checkInTitle);
            System.out.println("Title " + checkInTitle + " has been checked in.");
            showLMS();

        }
        else {
            System.out.println("Ok.");
        }
    }
}
