package cars;

import cars.engine.Engine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GasCar {

    @Qualifier("gasEngine")
    @Autowired
    private Engine engine;

    public GasCar(@Qualifier("gasEngine") Engine engine) {
        this.engine = engine;
    }

    public Engine getEngine() {
        return engine;
    }
}
