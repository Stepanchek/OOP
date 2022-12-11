import static org.junit.jupiter.api.Assertions.assertTrue;

import org.example.model.entities.Ammunition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import utils.AmmunitionArgumentProvider;

import java.lang.reflect.InvocationTargetException;


public class AmmunitionTest {
    @DisplayName("Check getters via inherited classes")
    @ParameterizedTest(name = "Getters for {0} checked")
    @ArgumentsSource(AmmunitionArgumentProvider.class)
    void gettersCheckTest(Class<? extends Ammunition> ammunitionClass) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Ammunition ammunition = ammunitionClass.getConstructor(String.class, double.class, double.class)
                .newInstance("ammunition", 34.2, 43.2);

        assertTrue(ammunitionClass.getSimpleName().equals(ammunition.getType()));
        assertTrue(ammunition.setName("ammunition1").getName().equals("ammunition1"));
        assertTrue(ammunition.setPrice(45.2).getPrice() == 45.2);
        assertTrue(ammunition.setWeight(2.3).getWeight() == 2.3);
    }
}