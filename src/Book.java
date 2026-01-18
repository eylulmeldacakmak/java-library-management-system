public class Book {

    //Attributes
    private String isbn;
    private String title;
    private String author;
    private int stock;

    //Constructor
    public Book(String isbn, String title, String author, int stock) throws IllegalArgumentException{
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        if(stock < 0) throw new IllegalArgumentException("Stock cannot be negative");
        this.stock = stock;
    }

    //Getters
    public String getIsbn(){
        return isbn;
    }
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public int getStock(){
        return stock;
    }

    //Methods
    public void increaseStock(){
        this.stock++;
    }
    public void decreaseStock() throws OutOfStockException{
        if(this.stock <= 0) throw new OutOfStockException("Stock is 0, cannot decrease further.");
        this.stock--;
    }

}
