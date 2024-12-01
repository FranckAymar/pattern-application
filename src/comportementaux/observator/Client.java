package comportementaux.observator;

public class Client {

    public static void main(String[] args) {
        EventManager eventManager = new EventManager();

        EmailAlertListener emailAlertListener = new EmailAlertListener();
        LoggingAlertListener loggingAlertListener = new LoggingAlertListener();

        eventManager.subscribe(emailAlertListener);
        eventManager.subscribe(loggingAlertListener);

        eventManager.notify(" Est-ce vous m'entendez ?");
    }
}
