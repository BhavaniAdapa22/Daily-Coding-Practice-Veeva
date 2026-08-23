import java.util.*;
class Book
{
    String title;
    String author;
    double price;
    public Book(String title,String author,double price)
    {
        this.title=title;
        this.author=author;
        this.price=price;
    }
}
class BookStore
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        HashMap<String,Book> hm=new HashMap<>();
        System.out.println("Enter n:");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter ISBN:");
            String isbn = sc.next();
            System.out.println("Enter Title:");
            sc.nextLine(); 
            String title = sc.nextLine();
            System.out.println("Enter Author");
            String author = sc.nextLine();
            System.out.println("Enter Price:");
            double price = sc.nextDouble();
            if (!hm.containsKey(isbn)) {
                hm.put(isbn,new Book(title,author,price));
            }
            else {
                System.out.println("No Duplicates are allowed");
            }
        }
        System.out.println("Enter a ISBN Number:");
        String isbn=sc.next();
        if(!hm.containsKey(isbn))
        {
            System.out.println("Book with isbn "+isbn+" does not exist in the collection");
        }
        else
        {
            Book book=hm.get(isbn);
            System.out.println("Book Details Are:");
            System.out.println("Title:"+book.title+"\tAuthor:"+book.author+"\tPrice:"+book.price);
        }
    }
}
