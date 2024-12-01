package comportementaux.visitor;


import comportementaux.visitor.shape.Dot;
import comportementaux.visitor.shape.Line;

public interface Visitor {
    void visitDot(Dot d);
    void visitLine(Line l);
}
