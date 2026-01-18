import java.util.*;
public abstract class Member implements HasBorrowLimit{

    //Attributes
    private String id;
    private String name;
    private ArrayList<Book> borrowedBooks;

    //Constructor
    public Member(String id, String name){
        this.id = id;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    //Getters
    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public ArrayList<Book> getBorrowedBooks(){
        return borrowedBooks;
    }

    //Methods
    public abstract String getMemberType();
    public abstract int getMaxBorrowLimit();

}
