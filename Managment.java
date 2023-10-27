//Dureh Wren,CEN 3024C, OCT 1st,2023
//Software Development I
/* The Management class is what manages the entire program as a whole pulling from other classes and executing the main method
   as well as doing all the storing, and printing*/

import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Managment {

    private static ArrayList<Book> LMS = new ArrayList<Book>();


    private void addBook(Book book){
        LMS.add(book);
    }


    private static void removeBookByID(String id){
        //System.out.println(book.getiD());
        LMS.removeIf(book -> book.getiD().equals(id));
    }

    public static void showLMS(){
        for (Book book : LMS){
            System.out.println(book.getiD());
            System.out.println(book.getTitle());
            System.out.println(book.getAuthor());
            System.out.println("-----------------");
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

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath)); //"C:\\Users\\dureh\\OneDrive - Knights - University of Central Florida\\Desktop\\LMStest.txt"

            while((line = br.readLine()) != null) {
                String[] reader = line.split(",");
                //System.out.println("Book - ID = " + reader[0] + ", Title = " + reader[1] + ", Author = " + reader[2]);
                Book book =new Book(reader[0], reader[1], reader[2]);
                LMS.add(book);
            }
            } catch (IOException var4) {
            var4.printStackTrace();
        }

        showLMS();

        System.out.println("Would you like to remove a book?");

        String removalCheck = scan.nextLine();

            if ((removalCheck.equals("y")) || (removalCheck.equals("Y")) || (removalCheck.equals("yes")) || (removalCheck.equals("Yes"))) {
                System.out.println("Please enter the ID of the book you would like to remove.");
                String removalID = scan.nextLine();
                removeBookByID(removalID);
            }
            else {
                System.out.println("Ok.");
            }


        //2 print that the database is printing
        //  print database
        System.out.println("Printing Library Managment Database.");
        showLMS();

        //3 ask for barcode, scan it, remove book from database
        //print a confirmation of deletion, reprint database

        //4 Ask for Title, scan it, remove book with title
        //print a confirmation of deletion, reprint database

        //5Ask the user for a title to check out.
        // Check out the book, print a confirmation message,  re-print the contents of the database to the screen.

        //Ask the user for a title to check in.
        // Check in the book, print a confirmation message, and re-print the contents of the database to the screen.
    }
}
