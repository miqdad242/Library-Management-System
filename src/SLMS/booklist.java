package SLMS;



/**
 *
 * @author Inshaf
 */
public class booklist {
    
    private String bookID, bookName, author,ISBN;
    
    public booklist(String bookID , String bookname , String author, String isbn){
    
        this.bookID = bookID;
        this.bookName=bookname;
        this.author = author;
        this.ISBN = isbn;
    }
    public String getBookID(){
        return bookID;
    }
    public String getBookName(){
        return bookName;
    }
    public String getauthor(){
        return author;
    }
    public String getISBN(){
        return ISBN;
    }
    
    
    
    
}
