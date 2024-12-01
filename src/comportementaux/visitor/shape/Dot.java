package comportementaux.visitor.shape;

import comportementaux.visitor.Visitor;

public class Dot implements Shape {
    @Override
    public void move(int x, int y) {

    }

    @Override
    public void draw() {

    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitDot(this);
    }
}
