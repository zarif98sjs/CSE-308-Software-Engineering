package service;

import mediator.Mediator;

public class JPDC implements Service{

    Mediator mediator;
    String organizationName;

    public JPDC(Mediator mediator)
    {
        this.organizationName = "JPDC";
        setMediator(mediator);
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public String getName() {
        return organizationName;
    }

    @Override
    public void recieveRequest(Service from) {
        mediator.recieveRequest(from,organizationName);
    }

    @Override
    public Service serveRequest() {
        return mediator.serveRequest(organizationName);
    }

    @Override
    public String toString() {
        return organizationName;
    }
}
