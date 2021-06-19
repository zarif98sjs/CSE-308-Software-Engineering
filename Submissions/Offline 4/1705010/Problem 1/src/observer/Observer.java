package observer;

import java.io.IOException;
import java.util.ArrayList;

public interface Observer {
    public void update(String text) throws IOException;
}
