import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
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
    private Lion lion;

    @Before
    public void beforeTest() throws Exception {
        lion = new Lion("Самец", feline);
    }

    @Test
    public void getKittensLionTest() {
        Mockito.when(feline.getKittens()).thenReturn(3);
        int expectedKittensLion = 3;
        int actualKittensLion = lion.getKittens();
        Assert.assertEquals(expectedKittensLion, actualKittensLion);
    }

    @Test
    public void getFoodLionTest() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expectedFoodLion = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFoodLion = lion.getFood();
        Assert.assertEquals(expectedFoodLion, actualFoodLion);
    }
}
