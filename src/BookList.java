import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Catalog")
public class BookList {

    private List<Book> books = new ArrayList<>();

    public BookList() {
    }

    @XmlElement(name = "Book")
    public List<Book> getBooks() {
        return books;
    }
    public void insertBooks(Book l) {
        books.add(l);
    }

    @Override
    public String toString() {
        return "BookList{" +
                "books=" + books +
                '}';
    }
}
