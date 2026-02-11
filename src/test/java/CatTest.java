import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    private Feline feline;

    @Test
    public void getSoundTest() {
        Cat cat = new Cat(feline);
        Assert.assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void getFoodTest() throws Exception {
        List<String> food = List.of("Мясо");
        Mockito.when(feline.eatMeat()).thenReturn(food);
        Cat cat = new Cat(feline);
        Assert.assertEquals(food, cat.getFood());
        Mockito.verify(feline).eatMeat();
    }
}