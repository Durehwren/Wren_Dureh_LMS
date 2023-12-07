/*Dureh Wren,CEN 3024C, OCT 1st,2023
*Software Development I
* The Book class is responsible for the creation of the book object parameters as well as the storage for methods to get and set values
of a book object*/

import java.time.LocalDate;


class Book {

    protected  String iD;
    protected String title;
    protected  String author;
    protected boolean checkedOut;
    protected LocalDate dueDate = null;


    /*
     * method: Book
     * parameters: iD, title, author
     * return: none
     * purpose:THis method creates the parameters needed to create a book object
     */
    Book(String iD, String title, String author, boolean checkedOut, LocalDate dueDate) {
        this.iD = iD;
        this.title = title;
        this.author = author;
        checkedOut = false;
        dueDate = null;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    public  String getiD() {
        return iD;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public  String getTitle() {
        return title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }
    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void setDueDate() {
        dueDate = LocalDate.now();
        this.dueDate = dueDate.plusDays(28);
    }

    public void resetDueDate() {
        dueDate = null;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }
}
