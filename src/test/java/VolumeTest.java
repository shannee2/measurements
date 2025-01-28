import org.example.Measurement;
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
        Measurement<VolumeUnit> volume = new Volume(1, VolumeUnit.MILLILITRE);

        Measurement<VolumeUnit> volumeInLitre = volume.convertTo(VolumeUnit.LITRE);
        Measurement<VolumeUnit> expectedVolume = new Volume(0.001, VolumeUnit.LITRE);

        assertEquals(expectedVolume, volumeInLitre);

    }

    @Test
    public void testReturnDecilitreValue_For1MilliLitre(){
        Measurement<VolumeUnit> volume = new Volume(1, VolumeUnit.MILLILITRE);

        Measurement<VolumeUnit> volumeInDecilitre = volume.convertTo(VolumeUnit.DECILITRE);
        Measurement<VolumeUnit> expectedVolume = new Volume(0.01, VolumeUnit.DECILITRE);

        assertEquals(expectedVolume, volumeInDecilitre);
    }

    @Test
    public void testReturnCentilitreValue_For1MilliLitre(){
        Measurement<VolumeUnit> volume = new Volume(1, VolumeUnit.MILLILITRE);

        Measurement<VolumeUnit> volumeInCentilitre = volume.convertTo(VolumeUnit.CENTILITRE);
        Measurement<VolumeUnit> expectedVolume = new Volume(0.1, VolumeUnit.CENTILITRE);

        assertEquals(expectedVolume, volumeInCentilitre);
    }

    @Test
    public void testReturnDecalitreValue_For1MilliLitre(){
        Measurement<VolumeUnit> volume = new Volume(1, VolumeUnit.MILLILITRE);

        Measurement<VolumeUnit> volumeInDecalitre = volume.convertTo(VolumeUnit.DECALITRE);
        Measurement<VolumeUnit> expectedVolume = new Volume(0.0001, VolumeUnit.DECALITRE);

        assertEquals(expectedVolume, volumeInDecalitre);
    }

    @Test
    public void testReturnKilolitreValue_For48MilliLitre(){
        Measurement<VolumeUnit> volume = new Volume(48, VolumeUnit.MILLILITRE);

        Measurement<VolumeUnit> volumeInKilolitre = volume.convertTo(VolumeUnit.KILOLITRE);
        Measurement<VolumeUnit> expectedVolume = new Volume(0.000048, VolumeUnit.KILOLITRE);

        assertEquals(expectedVolume, volumeInKilolitre);
    }

    @Test
    public void testReturnMillilitreValue_For4_5Centilitre(){
        Measurement<VolumeUnit> volume = new Volume(4.5, VolumeUnit.CENTILITRE);

        Measurement<VolumeUnit> volumeInMillilitre = volume.convertTo(VolumeUnit.MILLILITRE);
        Measurement<VolumeUnit> expectedVolume = new Volume(45, VolumeUnit.MILLILITRE);

        assertEquals(expectedVolume, volumeInMillilitre);
    }
}
