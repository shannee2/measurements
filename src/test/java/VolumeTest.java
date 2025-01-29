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
    public void testReturnLitreValue_For1MilliLitre(){
        Measurement volume = new Measurement(1, VolumeUnit.MILLILITRE);

        Measurement volumeInLitre = volume.convertTo(VolumeUnit.LITRE);
        Measurement expectedVolume = new Measurement(0.001, VolumeUnit.LITRE);

        assertEquals(expectedVolume, volumeInLitre);
    }

    @Test
    public void testReturnDecilitreValue_For1MilliLitre(){
        Measurement volume = new Measurement(1, VolumeUnit.MILLILITRE);

        Measurement volumeInDecilitre = volume.convertTo(VolumeUnit.DECILITRE);
        Measurement expectedVolume = new Measurement(0.01, VolumeUnit.DECILITRE);

        assertEquals(expectedVolume, volumeInDecilitre);
    }

    @Test
    public void testReturnCentilitreValue_For1MilliLitre(){
        Measurement volume = new Measurement(1, VolumeUnit.MILLILITRE);

        Measurement volumeInCentilitre = volume.convertTo(VolumeUnit.CENTILITRE);
        Measurement expectedVolume = new Measurement(0.1, VolumeUnit.CENTILITRE);

        assertEquals(expectedVolume, volumeInCentilitre);
    }

    @Test
    public void testReturnDecalitreValue_For1MilliLitre(){
        Measurement volume = new Measurement(1, VolumeUnit.MILLILITRE);

        Measurement volumeInDecalitre = volume.convertTo(VolumeUnit.DECALITRE);
        Measurement expectedVolume = new Measurement(0.0001, VolumeUnit.DECALITRE);

        assertEquals(expectedVolume, volumeInDecalitre);
    }

    @Test
    public void testReturnKilolitreValue_For48MilliLitre(){
        Measurement volume = new Measurement(48, VolumeUnit.MILLILITRE);

        Measurement volumeInKilolitre = volume.convertTo(VolumeUnit.KILOLITRE);
        Measurement expectedVolume = new Measurement(0.000048, VolumeUnit.KILOLITRE);

        assertEquals(expectedVolume, volumeInKilolitre);
    }

    @Test
    public void testReturnMillilitreValue_For4_5Centilitre(){
        Measurement volume = new Measurement(4.5, VolumeUnit.CENTILITRE);

        Measurement volumeInMillilitre = volume.convertTo(VolumeUnit.MILLILITRE);
        Measurement expectedVolume = new Measurement(45, VolumeUnit.MILLILITRE);

        assertEquals(expectedVolume, volumeInMillilitre);
    }

//    Sum Tests

    @Test
    public void testReturnSum_For1LitreAnd1Centilitre(){
        Measurement volume1 = new Measurement(1, VolumeUnit.LITRE);
        Measurement volume2 = new Measurement(1, VolumeUnit.CENTILITRE);

        Measurement sum = volume2.add(volume1, VolumeUnit.CENTILITRE);
        Measurement expectedSum = new Measurement(101, VolumeUnit.CENTILITRE);

        assertEquals(expectedSum, sum);
    }

    @Test
    public void testReturnSum_For1LitreAnd1Millilitre(){
        Measurement volume1 = new Measurement(1, VolumeUnit.LITRE);
        Measurement volume2 = new Measurement(1, VolumeUnit.MILLILITRE);

        Measurement sum = volume1.add(volume2, VolumeUnit.LITRE);
        Measurement expectedSum = new Measurement(1.001, VolumeUnit.LITRE);

        assertEquals(expectedSum, sum);
    }

    @Test
    public void testReturnSumInCentilitre_For1LitreAnd1Millilitre(){
        Measurement volume1 = new Measurement(1, VolumeUnit.LITRE);
        Measurement volume2 = new Measurement(1, VolumeUnit.MILLILITRE);

        Measurement sum = volume1.add(volume2, VolumeUnit.CENTILITRE);
        Measurement expectedSum = new Measurement(100.1, VolumeUnit.CENTILITRE);

        assertEquals(expectedSum, sum.convertTo(VolumeUnit.CENTILITRE));
    }
}