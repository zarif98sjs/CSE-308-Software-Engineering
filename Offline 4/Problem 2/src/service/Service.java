package service;

import mediator.Mediator;

public interface Service {
    void setMediator(Mediator mediator);
    String getName();
    void recieveRequest(Service from);
    Service serveRequest();
}
