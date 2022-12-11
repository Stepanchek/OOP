package utils;


import org.example.model.entities.armor.*;
import org.example.model.entities.weapons.*;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class AmmunitionArgumentProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(Helmet.class,
                Breastplate.class,
                Vambrace.class,
                Pants.class,
                Greaves.class,
                Arrow.class,
                Bow.class,
                Shield.class,
                Spear.class,
                Sword.class).map(Arguments::of);
    }
}