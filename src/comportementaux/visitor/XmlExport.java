package comportementaux.visitor;

import comportementaux.visitor.shape.Dot;
import comportementaux.visitor.shape.Line;

public class XmlExport implements Visitor {

    @Override
    public void visitDot(Dot d) {
        System.out.println("Je suis le visiteur pour l'export des dot");
    }

    @Override
    public void visitLine(Line l) {
        System.out.println("Je suis le visiteur pour l'export des line");
    }
}
