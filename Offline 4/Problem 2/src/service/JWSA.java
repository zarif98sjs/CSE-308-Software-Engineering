package service;

import mediator.Mediator;

public class JWSA implements Service{

    Mediator mediator;
    String organizationName;

    public JWSA(Mediator mediator)
    {
        this.organizationName = "JWSA";
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
