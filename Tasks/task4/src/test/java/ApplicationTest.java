import org.example.CustomClassLoader;
import org.example.Printer;
import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ApplicationTest {
    @Test
    void classLoaderOnNonJavaClassTest(){
        CustomClassLoader classLoader = new CustomClassLoader();

        try {
            Class<?> loadedClass = classLoader.loadClass("org.example.Cat");
            Field[] fields = loadedClass.getDeclaredFields();

            List<String> fieldsName = List.of("name","age");
            List<String> actualName = new ArrayList<>();

            for (Field field : fields){
                actualName.add(field.getName());
            }

            int classModifiers = loadedClass.getModifiers();

            assertTrue(Modifier.isPublic(classModifiers));
            assertFalse(Modifier.isAbstract(classModifiers));
            assertFalse(Modifier.isFinal(classModifiers));

            assertEquals(fieldsName,actualName);
            assertEquals(Serializable.class, loadedClass.getInterfaces()[0]);
        } catch (ClassNotFoundException e) {
            fail();
        }
    }

    @Test
    void printTest(){
        Printer printer = new Printer("org.example.Cat");
        printer.print();
    }

    @Test
    void classLoaderOnJavaClassTest() {
        CustomClassLoader loader = new CustomClassLoader();

        try {
            Class<?> loadedClass = loader.loadClass("java.util.ArrayList");

            assertEquals(AbstractList.class, loadedClass.getSuperclass());

            int classModifiers = loadedClass.getModifiers();

            assertTrue(Modifier.isPublic(classModifiers));
            assertFalse(Modifier.isAbstract(classModifiers));
            assertFalse(Modifier.isFinal(classModifiers));

            assertEquals(4, loadedClass.getInterfaces().length);
        } catch (ClassNotFoundException e) {
            fail();
        }
    }
}
