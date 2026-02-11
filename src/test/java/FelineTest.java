import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Mock
    private Feline feline;

    @Test
    public void eatMeatReturnsPredatorFood() throws Exception {
        Feline feline = Mockito.spy(new Feline());
        List<String> food = List.of("Мясо");
        Mockito.doReturn(food).when(feline).getFood("Хищник");
        Assert.assertEquals(food, feline.eatMeat());
    }

    @Test
    public void getFamilyTest() {
        Feline feline = new Feline();
        Assert.assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensWithoutParamTest() {
        Feline feline = new Feline();
        Assert.assertEquals(1, feline.getKittens());
    }

    @Test
    public void getKittensWithParamTest() {
        Feline feline = new Feline();
        Assert.assertEquals(5, feline.getKittens(5));
    }
}