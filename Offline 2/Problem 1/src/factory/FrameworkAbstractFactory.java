package factory;

import component.framework.Framework;

public abstract class FrameworkAbstractFactory {
    public abstract Framework getFramework(String name);
}
