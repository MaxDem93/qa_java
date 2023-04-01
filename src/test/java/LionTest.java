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
    Feline feline = new Feline();

    @Test
    public void getKittensReturnsForLion() throws Exception {
        Lion lion = new Lion("Самка",feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int expectedKittens = 1;
        int actualKittens = lion.getKittens();
        Assert.assertEquals(expectedKittens, actualKittens);
    }

    @Test
    public void getFoodReturnsForLion() throws Exception {
        Lion lion = new Lion("Самец", feline);
        List<String> expectedEatMeat = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedEatMeat);
        List<String> actualEatMeat = lion.getFood();
        Assert.assertEquals(expectedEatMeat, actualEatMeat);
    }

    @Test(expected = Exception.class)
    public void doesHaveManeExceptionTest() throws Exception {
        Lion lion = new Lion("Unknown", feline);
    }

}