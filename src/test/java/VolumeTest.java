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
    public void testReturnLitreValue_For1MilliLitre(){
        Volume volume = new Volume(1, Unit.MILLILITRE);

        Volume volumeInLitre = volume.convertTo(Unit.LITRE);
        Volume expectedVolume = new Volume(0.001, Unit.LITRE);

        assertEquals(expectedVolume, volumeInLitre);

        }

    @Test
    public void testReturnDecilitreValue_For1MilliLitre(){
        Volume volume = new Volume(1, Unit.MILLILITRE);

        Volume volumeInDecilitre = volume.convertTo(Unit.DECILITRE);
        Volume expectedVolume = new Volume(0.01, Unit.DECILITRE);

        assertEquals(expectedVolume, volumeInDecilitre);
    }

    @Test
    public void testReturnCentilitreValue_For1MilliLitre(){
        Volume volume = new Volume(1, Unit.MILLILITRE);

        Volume volumeInCentilitre = volume.convertTo(Unit.CENTILITRE);
        Volume expectedVolume = new Volume(0.1, Unit.CENTILITRE);

        assertEquals(expectedVolume, volumeInCentilitre);
    }

    @Test
    public void testReturnDecalitreValue_For1MilliLitre(){
        Volume volume = new Volume(1, Unit.MILLILITRE);

        Volume volumeInDecalitre = volume.convertTo(Unit.DECALITRE);
        Volume expectedVolume = new Volume(0.0001, Unit.DECALITRE);

        assertEquals(expectedVolume, volumeInDecalitre);
    }

    @Test
    public void testReturnKilolitreValue_For48MilliLitre(){
        Volume volume = new Volume(48, Unit.MILLILITRE);

        Volume volumeInKilolitre = volume.convertTo(Unit.KILOLITRE);
        Volume expectedVolume = new Volume(0.000048, Unit.KILOLITRE);

        assertEquals(expectedVolume, volumeInKilolitre);
    }

    @Test
    public void testReturnMillilitreValue_For4_5Centilitre(){
        Volume volume = new Volume(4.5, Unit.CENTILITRE);

        Volume volumeInMillilitre = volume.convertTo(Unit.MILLILITRE);
        Volume expectedVolume = new Volume(45, Unit.MILLILITRE);

        assertEquals(expectedVolume, volumeInMillilitre);}
}
