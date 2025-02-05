import org.example.MassUnit;
import org.example.Measurement;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MassTest {
    @Test
    public void testThrowException_WhenInputMinus1() {
        assertThrows(IllegalArgumentException.class, () -> new Measurement<MassUnit>(-1, MassUnit.GRAM));
    }

    @Test
    public void testThrowException_WhenInput0() {
        assertThrows(IllegalArgumentException.class, () -> new Measurement<MassUnit>(0, MassUnit.GRAM));
    }

    @Test
    public void testReturnKilogramValue_For1Milligram() {
        Measurement<MassUnit> mass = new Measurement<>(1, MassUnit.MILLIGRAM);

        Measurement<MassUnit> massInKilogram = mass.convertTo(MassUnit.KILOGRAM);
        Measurement<MassUnit> expectedMass = new Measurement<>(0.000001, MassUnit.KILOGRAM);

        assertEquals(expectedMass, massInKilogram);
    }

    @Test
    public void testReturnDecagramValue_For1Milligram() {
        Measurement<MassUnit> mass = new Measurement<>(1, MassUnit.MILLIGRAM);

        Measurement<MassUnit> massInDecagram = mass.convertTo(MassUnit.DECAGRAM);
        Measurement<MassUnit> expectedMass = new Measurement<>(0.0001, MassUnit.DECAGRAM);

        assertEquals(expectedMass, massInDecagram);
    }

    @Test
    public void testReturnDecigramValue_For1Milligram() {
        Measurement<MassUnit> mass = new Measurement<>(1, MassUnit.MILLIGRAM);

        Measurement<MassUnit> massInDecigram = mass.convertTo(MassUnit.DECIGRAM);
        Measurement<MassUnit> expectedMass = new Measurement<>(0.01, MassUnit.DECIGRAM);

        assertEquals(expectedMass, massInDecigram);
    }

    @Test
    public void testReturnCentigramValue_For1Milligram() {
        Measurement<MassUnit> mass = new Measurement<>(1, MassUnit.MILLIGRAM);

        Measurement<MassUnit> massInCentigram = mass.convertTo(MassUnit.CENTIGRAM);
        Measurement<MassUnit> expectedMass = new Measurement<>(0.1, MassUnit.CENTIGRAM);

        assertEquals(expectedMass, massInCentigram);
    }

    @Test
    public void testReturnGramValue_For48Milligram() {
        Measurement<MassUnit> mass = new Measurement<>(48, MassUnit.MILLIGRAM);

        Measurement<MassUnit> massInGram = mass.convertTo(MassUnit.GRAM);
        Measurement<MassUnit> expectedMass = new Measurement<>(0.048, MassUnit.GRAM);

        assertEquals(expectedMass, massInGram);
    }

    @Test
    public void testReturnMilligramValue_For4_5Centigram() {
        Measurement<MassUnit> mass = new Measurement<>(4.5, MassUnit.CENTIGRAM);

        Measurement<MassUnit> massInMilligram = mass.convertTo(MassUnit.MILLIGRAM);
        Measurement<MassUnit> expectedMass = new Measurement<>(45, MassUnit.MILLIGRAM);

        assertEquals(expectedMass, massInMilligram);
    }

    // Sum Tests

    @Test
    public void testReturnSum_For1GramAnd1Milligram() {
        Measurement<MassUnit> mass1 = new Measurement<>(1, MassUnit.GRAM);
        Measurement<MassUnit> mass2 = new Measurement<>(1, MassUnit.MILLIGRAM);

        Measurement<MassUnit> sum = mass1.add(mass2, MassUnit.GRAM);
        Measurement<MassUnit> expectedSum = new Measurement<>(1.001, MassUnit.GRAM);

        assertEquals(expectedSum, sum);
    }

    @Test
    public void testReturnSumInCentigram_For1GramAnd1Centigram() {
        Measurement<MassUnit> mass1 = new Measurement<>(1, MassUnit.GRAM);
        Measurement<MassUnit> mass2 = new Measurement<>(1, MassUnit.CENTIGRAM);

        Measurement<MassUnit> sum = mass1.add(mass2, MassUnit.CENTIGRAM);
        Measurement<MassUnit> expectedSum = new Measurement<>(101, MassUnit.CENTIGRAM);

        assertEquals(expectedSum, sum);
    }

    @Test
    public void testReturnSum_For1DecagramAnd1Gram() {
        Measurement<MassUnit> mass1 = new Measurement<>(1, MassUnit.DECAGRAM);
        Measurement<MassUnit> mass2 = new Measurement<>(1, MassUnit.GRAM);

        Measurement<MassUnit> sum = mass1.add(mass2, MassUnit.DECAGRAM);
        Measurement<MassUnit> expectedSum = new Measurement<>(1.1, MassUnit.DECAGRAM);

        assertEquals(expectedSum, sum);
    }
}