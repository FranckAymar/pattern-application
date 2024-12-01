package comportementaux.visitor;

import comportementaux.visitor.shape.Dot;
import comportementaux.visitor.shape.Shape;

public class Client {

    public static void main(String[] args) {
        Dot dot = new Dot();

        XmlExport xmlExport = new XmlExport();

        dot.accept(xmlExport);
    }
}
