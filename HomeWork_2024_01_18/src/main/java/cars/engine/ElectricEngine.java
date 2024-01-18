package cars.engine;

import org.springframework.stereotype.Component;

@Component
public class ElectricEngine implements Engine{
    @Override
    public void useEngine() {
        System.out.println("This car use Electric engine");
    }
}
