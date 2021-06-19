package mediator;

import service.Service;

public interface Mediator {
    void recieveRequest(Service from, String to);
    Service serveRequest(String from);
}
