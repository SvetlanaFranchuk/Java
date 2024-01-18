package cars;

import cars.engine.Engine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ElectricCar {

    @Qualifier("electricEngine")
    @Autowired
    private Engine engine;

    public ElectricCar(@Qualifier("electricEngine") Engine engine) {
        this.engine = engine;
    }

    public Engine getEngine() {
        return engine;
    }
}
