package factory;

import component.framework.Framework;
import teagaspackage.TeaGASPackage;

public abstract class TeaGASPackageAbstractFactory {

    public abstract TeaGASPackage getTeaGASPackage(String name);
}
