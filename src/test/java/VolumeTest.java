import org.example.VolumeUnit;
import org.example.Volume;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VolumeTest {
    @Test
    public void testThrowException_WhenInputMinus1(){
        assertThrows(IllegalArgumentException.class, ()-> new Volume(-1, VolumeUnit.CENTILITRE));
    }

    @Test
    public void testThrowException_WhenInput0(){
        assertThrows(IllegalArgumentException.class, ()-> new Volume(0, VolumeUnit.CENTILITRE));
    }

    @Test
    public void testReturnLitreValue_For1MilliLitre(){
        Volume volume = new Volume(1, VolumeUnit.MILLILITRE);

        Volume volumeInLitre = volume.convertTo(VolumeUnit.LITRE);
        Volume expectedVolume = new Volume(0.001, VolumeUnit.LITRE);

        assertEquals(expectedVolume, volumeInLitre);

        }

    @Test
    public void testReturnDecilitreValue_For1MilliLitre(){
        Volume volume = new Volume(1, VolumeUnit.MILLILITRE);

        Volume volumeInDecilitre = volume.convertTo(VolumeUnit.DECILITRE);
        Volume expectedVolume = new Volume(0.01, VolumeUnit.DECILITRE);

        assertEquals(expectedVolume, volumeInDecilitre);
    }

    @Test
    public void testReturnCentilitreValue_For1MilliLitre(){
        Volume volume = new Volume(1, VolumeUnit.MILLILITRE);

        Volume volumeInCentilitre = volume.convertTo(VolumeUnit.CENTILITRE);
        Volume expectedVolume = new Volume(0.1, VolumeUnit.CENTILITRE);

        assertEquals(expectedVolume, volumeInCentilitre);
    }

    @Test
    public void testReturnDecalitreValue_For1MilliLitre(){
        Volume volume = new Volume(1, VolumeUnit.MILLILITRE);

        Volume volumeInDecalitre = volume.convertTo(VolumeUnit.DECALITRE);
        Volume expectedVolume = new Volume(0.0001, VolumeUnit.DECALITRE);

        assertEquals(expectedVolume, volumeInDecalitre);
    }

    @Test
    public void testReturnKilolitreValue_For48MilliLitre(){
        Volume volume = new Volume(48, VolumeUnit.MILLILITRE);

        Volume volumeInKilolitre = volume.convertTo(VolumeUnit.KILOLITRE);
        Volume expectedVolume = new Volume(0.000048, VolumeUnit.KILOLITRE);

        assertEquals(expectedVolume, volumeInKilolitre);
    }

    @Test
    public void testReturnMillilitreValue_For4_5Centilitre(){
        Volume volume = new Volume(4.5, VolumeUnit.CENTILITRE);

        Volume volumeInMillilitre = volume.convertTo(VolumeUnit.MILLILITRE);
        Volume expectedVolume = new Volume(45, VolumeUnit.MILLILITRE);

        assertEquals(expectedVolume, volumeInMillilitre);}
}
