package factory;

import component.internet.Internet;

public abstract class InternetAbstractFactory {
    public abstract Internet getInternet(String name);
}
