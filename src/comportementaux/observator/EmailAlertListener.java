package comportementaux.observator;

public class EmailAlertListener implements EventListeners{

    @Override
    public void notify(String filename) {
        System.out.println("Email alert" + filename);
    }
}
