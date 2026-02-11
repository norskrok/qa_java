import com.example.Animal;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class AnimalTest {

    @Test
    public void getFoodHerbivoreTest() throws Exception {
        Animal animal = new Animal();
        List<String> expected = List.of("Трава", "Различные растения");
        Assert.assertEquals(expected, animal.getFood("Травоядное"));
    }

    @Test
    public void getFoodPredatorTest() throws Exception {
        Animal animal = new Animal();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals(expected, animal.getFood("Хищник"));
    }

    @Test
    public void getFoodThrowsExceptionTest() {
        Animal animal = new Animal();
        try {
            animal.getFood("Кот");
            Assert.fail("Ожидали Exception");
        } catch (Exception e) {
            Assert.assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", e.getMessage());
        }
    }

    @Test
    public void getFamilyTest() {
        Animal animal = new Animal();
        Assert.assertTrue(animal.getFamily().contains("кошачьи"));
    }
}
