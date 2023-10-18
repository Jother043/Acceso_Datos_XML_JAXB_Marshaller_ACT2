public class XmlException extends Exception{

    public XmlException(String message) {
        super("Error: " + message);
    }
}
