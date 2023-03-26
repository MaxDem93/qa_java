import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
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
    private Cat cat;

    @Before
    public void beforeTest() {
        cat = new Cat(feline);
    }

    @Test
    public void getSoundTest() {
        String expectedSound = "Мяу";
        String actualSound = cat.getSound();
        Assert.assertEquals(expectedSound, actualSound);
    }

    @Test
    public void getFoodTest() throws Exception {
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Трава", "Различные растения"));
        List<String> expectedFood = List.of("Трава", "Различные растения");
        List<String> actualFood = cat.getFood();
        Assert.assertEquals(expectedFood, actualFood);
    }
}
