package comportementaux.observator;

import java.util.ArrayList;
import java.util.List;

public class EventManager {

    private final List<EventListeners> listeners;

    public EventManager() {
        listeners = new ArrayList<>();
    }

    public void subscribe(EventListeners listener) {
        listeners.add(listener);
    }

    public void unsubscribe(EventListeners listener) {
        listeners.remove(listener);
    }

    public void notify(String filename) {
        listeners.forEach(l -> l.notify(filename));
    }
}
