import org.example.MassUnit;
import org.example.Mass;
import org.example.Measurement;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MassTest {
    @Test
    public void testThrowException_WhenInputMinus1() {
        assertThrows(IllegalArgumentException.class, () -> new Mass(-1, MassUnit.GRAM));
    }

    @Test
    public void testThrowException_WhenInput0() {
        assertThrows(IllegalArgumentException.class, () -> new Mass(0, MassUnit.GRAM));
    }

    @Test
    public void testReturnKilogramValue_For1Milligram() {
        Mass mass = new Mass(1, MassUnit.MILLIGRAM);

        Measurement massInKilogram = mass.convertTo(MassUnit.KILOGRAM);
        Mass expectedMass = new Mass(0.000001, MassUnit.KILOGRAM);

        assertEquals(expectedMass, massInKilogram);
    }

    @Test
    public void testReturnDecagramValue_For1Milligram() {
        Mass mass = new Mass(1, MassUnit.MILLIGRAM);

        Measurement massInDecagram = mass.convertTo(MassUnit.DECAGRAM);
        Mass expectedMass = new Mass(0.0001, MassUnit.DECAGRAM);

        assertEquals(expectedMass, massInDecagram);
    }

    @Test
    public void testReturnDecigramValue_For1Milligram() {
        Mass mass = new Mass(1, MassUnit.MILLIGRAM);

        Measurement massInDecigram = mass.convertTo(MassUnit.DECIGRAM);
        Mass expectedMass = new Mass(0.01, MassUnit.DECIGRAM);

        assertEquals(expectedMass, massInDecigram);
    }

    @Test
    public void testReturnCentigramValue_For1Milligram() {
        Mass mass = new Mass(1, MassUnit.MILLIGRAM);

        Measurement massInCentigram = mass.convertTo(MassUnit.CENTIGRAM);
        Mass expectedMass = new Mass(0.1, MassUnit.CENTIGRAM);

        assertEquals(expectedMass, massInCentigram);
    }

    @Test
    public void testReturnGramValue_For48Milligram() {
        Mass mass = new Mass(48, MassUnit.MILLIGRAM);

        Measurement massInGram = mass.convertTo(MassUnit.GRAM);
        Mass expectedMass = new Mass(0.048, MassUnit.GRAM);

        assertEquals(expectedMass, massInGram);
    }

    @Test
    public void testReturnMilligramValue_For4_5Centigram() {
        Mass mass = new Mass(4.5, MassUnit.CENTIGRAM);

        Measurement massInMilligram = mass.convertTo(MassUnit.MILLIGRAM);
        Mass expectedMass = new Mass(45, MassUnit.MILLIGRAM);

        assertEquals(expectedMass, massInMilligram);
    }
}