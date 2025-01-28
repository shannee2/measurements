import org.example.MassUnit;
import org.example.Measurement;
import org.example.VolumeUnit;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VolumeTest {
    @Test
    public void testThrowException_WhenInputMinus1(){
        assertThrows(IllegalArgumentException.class, ()-> new Measurement(-1, VolumeUnit.CENTILITRE));
    }

    @Test
    public void testThrowException_WhenInput0(){
        assertThrows(IllegalArgumentException.class, ()-> new Measurement(0, VolumeUnit.CENTILITRE));
    }

    @Test
    public void testThrowException_WhenConvertingToDifferentUnitType(){
        Measurement volume = new Measurement(1, VolumeUnit.LITRE);

        assertThrows(IllegalArgumentException.class, ()-> volume.convertTo(MassUnit.GRAM));
    }

    @Test
    public void testReturnLitreValue_For1MilliLitre(){
        Measurement volume = new Measurement(1, VolumeUnit.MILLILITRE);

        Measurement volumeInLitre = (Measurement) volume.convertTo(VolumeUnit.LITRE);
        Measurement expectedVolume = new Measurement(0.001, VolumeUnit.LITRE);

        assertEquals(expectedVolume, volumeInLitre);
    }

    @Test
    public void testReturnDecilitreValue_For1MilliLitre(){
        Measurement volume = new Measurement(1, VolumeUnit.MILLILITRE);

        Measurement volumeInDecilitre = (Measurement) volume.convertTo(VolumeUnit.DECILITRE);
        Measurement expectedVolume = new Measurement(0.01, VolumeUnit.DECILITRE);

        assertEquals(expectedVolume, volumeInDecilitre);
    }

    @Test
    public void testReturnCentilitreValue_For1MilliLitre(){
        Measurement volume = new Measurement(1, VolumeUnit.MILLILITRE);

        Measurement volumeInCentilitre = (Measurement) volume.convertTo(VolumeUnit.CENTILITRE);
        Measurement expectedVolume = new Measurement(0.1, VolumeUnit.CENTILITRE);

        assertEquals(expectedVolume, volumeInCentilitre);
    }

    @Test
    public void testReturnDecalitreValue_For1MilliLitre(){
        Measurement volume = new Measurement(1, VolumeUnit.MILLILITRE);

        Measurement volumeInDecalitre = (Measurement) volume.convertTo(VolumeUnit.DECALITRE);
        Measurement expectedVolume = new Measurement(0.0001, VolumeUnit.DECALITRE);

        assertEquals(expectedVolume, volumeInDecalitre);
    }

    @Test
    public void testReturnKilolitreValue_For48MilliLitre(){
        Measurement volume = new Measurement(48, VolumeUnit.MILLILITRE);

        Measurement volumeInKilolitre = (Measurement) volume.convertTo(VolumeUnit.KILOLITRE);
        Measurement expectedVolume = new Measurement(0.000048, VolumeUnit.KILOLITRE);

        assertEquals(expectedVolume, volumeInKilolitre);
    }

    @Test
    public void testReturnMillilitreValue_For4_5Centilitre(){
        Measurement volume = new Measurement(4.5, VolumeUnit.CENTILITRE);

        Measurement volumeInMillilitre = (Measurement) volume.convertTo(VolumeUnit.MILLILITRE);
        Measurement expectedVolume = new Measurement(45, VolumeUnit.MILLILITRE);

        assertEquals(expectedVolume, volumeInMillilitre);
    }
}