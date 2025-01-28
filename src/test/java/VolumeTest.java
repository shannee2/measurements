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
    public void testReturnUnit_WhenInput1Decilitre(){
        Volume volume = new Volume(1, Unit.DECILITRE);

        Unit unit = volume.getUnit();

        assertEquals(Unit.DECILITRE, unit);
    }

    @Test
    public void testReturnLitreValue_For1MilliLitre(){
        Volume volume = new Volume(1, Unit.MILLILITRE);

        Volume volumeInLitre = volume.convertTo(Unit.LITRE);
        double value = volumeInLitre.getValue();

        assertEquals(0.001, value);
    }

    @Test
    public void testReturnDecilitreValue_For1MilliLitre(){
        Volume volume = new Volume(1, Unit.MILLILITRE);

        Volume volumeInDecilitre = volume.convertTo(Unit.DECILITRE);
        double value = volumeInDecilitre.getValue();

        assertEquals(0.01, value);
    }

    @Test
    public void testReturnCentilitreValue_For1MilliLitre(){
        Volume volume = new Volume(1, Unit.MILLILITRE);

        Volume volumeInCentilitre = volume.convertTo(Unit.CENTILITRE);
        double value = volumeInCentilitre.getValue();

        assertEquals(0.1, value);
    }

    @Test
    public void testReturnDecalitreValue_For1MilliLitre(){
        Volume volume = new Volume(1, Unit.MILLILITRE);

        Volume volumeInDecalitre = volume.convertTo(Unit.DECALITRE);
        double value = volumeInDecalitre.getValue();

        assertEquals(0.0001, value);
    }
}
