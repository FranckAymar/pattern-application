package comportementaux.visitor.shape;

import comportementaux.visitor.Visitor;

public interface Shape {
    void move(int x, int y);
    void draw();
    void accept(Visitor visitor);
}
