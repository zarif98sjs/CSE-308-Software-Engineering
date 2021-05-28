package component.framework;

public class FrameworkFactory{

    public static Framework getFramework(String name) {

        if(name.equalsIgnoreCase("django")) {
            return new Django();
        }
        else if(name.equalsIgnoreCase("laravel")) {
            return new Laravel();
        }
        else if(name.equalsIgnoreCase("spring")) {
            return new Spring();
        }

        return null;
    }
}
