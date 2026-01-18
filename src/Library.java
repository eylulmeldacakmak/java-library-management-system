import java.util.*;
public class Library {

    //Attributes
    private HashMap<String, Book> books;
    private HashMap<String, Member> members;

    //Constructor
    public Library(){
        books = new HashMap<>();
        members = new HashMap<>();
    }

    //Methods
    //1. Book Methods
    public Book findBookByIsbn(String isbn) throws BookNotFoundException{
        Book book = books.get(isbn);
        if(book == null) throw new BookNotFoundException("Book not found!!");
        return book;
    }
    public void addBook(Book book){
        this.books.put(book.getIsbn(), book);
    }
    //method overload
    public void removeBook(String isbn) throws BookNotFoundException{
        if(!books.containsKey(isbn)) throw new BookNotFoundException("Book not found!!");
        this.books.remove(isbn);
    }
    public void listBooks(){
        if(books.isEmpty()){
            System.out.println("No books in library.");
            return;
        }
        for(Book b : books.values()){
            System.out.println("ISBN: " + b.getIsbn() + " | Title: " + b.getTitle() + " | Author: " + b.getAuthor() + " | Stock: " + b.getStock());
        }
    }

    //2. Member Methods
    public Member findMemberById(String id) throws MemberNotFoundException{
        Member member = members.get(id);
        if(member == null) throw new MemberNotFoundException("Member not found!!");
        return member;
    }
    public void addMember(Member member){
        this.members.put(member.getId(), member);
    }
    public void removeMember(String id) throws MemberNotFoundException{
        if(!members.containsKey(id)) throw new MemberNotFoundException("Member not found!!");
        members.remove(id);
    }
    public void listMembers(){
        if(members.isEmpty()){
            System.out.println("No members registered.");
            return;
        }
        for(Member m : members.values()){
            System.out.println("ID: " + m.getId() + " | Name: " + m.getName() + " | Type: " + m.getMemberType() + " | Borrowed: " + m.getBorrowedBooks().size());
        }
    }

    //3. Borrow/Return Methods
    public void borrowBook(String id, String isbn) throws MemberNotFoundException, BookNotFoundException, BorrowLimitExceededException, OutOfStockException, BookAlreadyBorrowedException{
        Member member = findMemberById(id);
        Book book = findBookByIsbn(isbn);
        for (Book b : member.getBorrowedBooks()) {
            if (b.getIsbn().equals(isbn)) {
                throw new BookAlreadyBorrowedException("Book already borrowed by member.");
            }
        }
        if(member.getBorrowedBooks().size() >= member.getMaxBorrowLimit()) throw new BorrowLimitExceededException("Borrow limit exceeded!!");
        book.decreaseStock();
        member.getBorrowedBooks().add(book);
    }

    public void returnBook(String id, String isbn) throws MemberNotFoundException, BookNotFoundException, BookNotBorrowedException{
        Member member = findMemberById(id);
        Book book = findBookByIsbn(isbn);
        Book found = null;
        for(Book b : member.getBorrowedBooks()){
            if(b.getIsbn().equals(isbn)){
                found = b;
                break;
            }
        }
        if(found == null) throw new BookNotBorrowedException("Member did not borrow this book.");
        member.getBorrowedBooks().remove(found);
        book.increaseStock();
    }

}
