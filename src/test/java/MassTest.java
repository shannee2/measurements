import org.example.MassUnit;
import org.example.Measurement;
import org.example.VolumeUnit;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MassTest {
    @Test
    public void testThrowException_WhenInputMinus1() {
        assertThrows(IllegalArgumentException.class, () -> new Measurement(-1, MassUnit.GRAM));
    }

    @Test
    public void testThrowException_WhenInput0() {
        assertThrows(IllegalArgumentException.class, () -> new Measurement(0, MassUnit.GRAM));
    }

    @Test
    public void testThrowException_WhenConvertingToDifferentUnitType() {
        Measurement mass = new Measurement(1, MassUnit.GRAM);

        assertThrows(IllegalArgumentException.class, () -> mass.convertTo(VolumeUnit.LITRE));
    }

    @Test
    public void testReturnKilogramValue_For1Milligram() {
        Measurement mass = new Measurement(1, MassUnit.MILLIGRAM);

        Measurement massInKilogram = (Measurement) mass.convertTo(MassUnit.KILOGRAM);

        Measurement expectedMass = new Measurement(0.000001, MassUnit.KILOGRAM);

        assertEquals(expectedMass, massInKilogram);
    }

    @Test
    public void testReturnDecagramValue_For1Milligram() {
        Measurement mass = new Measurement(1, MassUnit.MILLIGRAM);

        Measurement massInDecagram = (Measurement) mass.convertTo(MassUnit.DECAGRAM);
        Measurement expectedMass = new Measurement(0.0001, MassUnit.DECAGRAM);

        assertEquals(expectedMass, massInDecagram);
    }

    @Test
    public void testReturnDecigramValue_For1Milligram() {
        Measurement mass = new Measurement(1, MassUnit.MILLIGRAM);

        Measurement massInDecigram = (Measurement) mass.convertTo(MassUnit.DECIGRAM);
        Measurement expectedMass = new Measurement(0.01, MassUnit.DECIGRAM);

        assertEquals(expectedMass, massInDecigram);
    }

    @Test
    public void testReturnCentigramValue_For1Milligram() {
        Measurement mass = new Measurement(1, MassUnit.MILLIGRAM);

        Measurement massInCentigram = (Measurement) mass.convertTo(MassUnit.CENTIGRAM);
        Measurement expectedMass = new Measurement(0.1, MassUnit.CENTIGRAM);

        assertEquals(expectedMass, massInCentigram);
    }

    @Test
    public void testReturnGramValue_For48Milligram() {
        Measurement mass = new Measurement(48, MassUnit.MILLIGRAM);

        Measurement massInGram = (Measurement) mass.convertTo(MassUnit.GRAM);
        Measurement expectedMass = new Measurement(0.048, MassUnit.GRAM);

        assertEquals(expectedMass, massInGram);
    }

    @Test
    public void testReturnMilligramValue_For4_5Centigram() {
        Measurement mass = new Measurement(4.5, MassUnit.CENTIGRAM);

        Measurement massInMilligram = (Measurement) mass.convertTo(MassUnit.MILLIGRAM);
        Measurement expectedMass = new Measurement(45, MassUnit.MILLIGRAM);

        assertEquals(expectedMass, massInMilligram);
    }
}