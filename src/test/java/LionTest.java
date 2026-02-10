import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline feline;

    @Test
    public void getKittens() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(2);
        Lion lion = new Lion("Самец", feline);
        Assert.assertEquals(2, lion.getKittens());
        Mockito.verify(feline).getKittens();
    }

    @Test
    public void getFood() throws Exception {
        List<String> food = List.of("Мясо", "Птица");
        Mockito.when(feline.getFood("Хищник")).thenReturn(food);
        Lion lion = new Lion("Самка", feline);
        Assert.assertEquals(food, lion.getFood());
        Mockito.verify(feline).getFood("Хищник");
    }

    @Test
    public void maleHasMane() throws Exception {
        Lion lion = new Lion("Самец", null);
        Assert.assertTrue(lion.doesHaveMane());
    }

    @Test
    public void femaleHasNoMane() throws Exception {
        Lion lion = new Lion("Самка", null);
        Assert.assertFalse(lion.doesHaveMane());
    }

    @Test
    public void constructorThrowsException() throws Exception {
        try {
            new Lion("Кот", feline);
            Assert.fail("Ожидали Exception");
        } catch (Exception e) {
            Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка", e.getMessage());
        }
    }
}