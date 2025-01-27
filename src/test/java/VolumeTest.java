import org.example.Unit;
import org.example.Volume;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VolumeTest {
    @Test
    public void testThrowException_WhenInputMinus1(){
        assertThrows(IllegalArgumentException.class, ()-> new Volume(-1, Unit.CENTILITRE));
    }

    @Test
    public void testThrowException_WhenInput0(){
        assertThrows(IllegalArgumentException.class, ()-> new Volume(0, Unit.CENTILITRE));
    }

    @Test
    public void testReturnValue_WhenInput1(){
        Volume volume = new Volume(1, Unit.CENTILITRE);

        double value = volume.getValue();

        assertEquals(1, volume.getValue());
    }

    @Test
    public void testReturnValue_WhenInput100(){
        Volume volume = new Volume(100, Unit.CENTILITRE);

        double value = volume.getValue();

        assertEquals(100, value);
    }

    @Test
    public void testReturnUnit_WhenInput1Centilitre(){
        Volume volume = new Volume(1, Unit.CENTILITRE);

        Unit unit = volume.getUnit();

        assertEquals(Unit.CENTILITRE, unit);
    }

    @Test
    public void testReturnLitreValue_For1MilliLitre(){
        Volume volume = new Volume(1, Unit.MILLILITRE);

        Volume volumeInLitre = new Volume(volume.convertTo(Unit.LITRE).getValue(), Unit.LITRE);

        assertEquals(0.001, volumeInLitre.getValue());
    }
}
