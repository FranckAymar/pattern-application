package comportementaux.observator;

public class LoggingAlertListener implements EventListeners{

    @Override
    public void notify(String filename) {
        System.out.println("Logging alert" + filename);
    }
}
