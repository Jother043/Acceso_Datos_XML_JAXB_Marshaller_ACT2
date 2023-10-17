import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class CrearXML {
    public static void main(String[] args) {
        try {
            xmlToBookList();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public static void xmlToBookList() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(BookList.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        File file = new File("books.xml");
        BookList bookList = (BookList) unmarshaller.unmarshal(file);
        System.out.println(bookList.toString());
    }
}
