package comportementaux.strategy;

public class Client {

    public static void main(String[] args) {
        Context context = new Context();

        //Possibilité de faire des if, afin de sélectionner la bonne implémentation
        context.setStrategy(new ConcreteStrategyAdd());

        int execute = context.execute(2, 3);

        System.out.println(execute);
    }

}
