import org.example.Measurement;
import org.example.Temperature;
import org.example.TemperatureUnit;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TemperatureTest {

    @Test
    public void testThrowException_WhenInputMinus1K() {
        assertThrows(IllegalArgumentException.class, () -> new Temperature(-1, TemperatureUnit.KELVIN));
    }

    @Test
    public void testReturnFahrenheitValue_For1Celsius() {
        Measurement<TemperatureUnit> temp = new Temperature(1, TemperatureUnit.CELSIUS);

        Measurement<TemperatureUnit> tempInFahrenheit = temp.convertTo(TemperatureUnit.FAHRENHEIT);
        Measurement<TemperatureUnit> expectedTemp = new Temperature(33.8, TemperatureUnit.FAHRENHEIT);

        assertEquals(expectedTemp, tempInFahrenheit);
    }

    @Test
    public void testReturnKelvinValue_For1Celsius() {
        Measurement<TemperatureUnit> temp = new Temperature(1, TemperatureUnit.CELSIUS);

        Measurement<TemperatureUnit> tempInKelvin = temp.convertTo(TemperatureUnit.KELVIN);
        Measurement<TemperatureUnit> expectedTemp = new Temperature(274.15, TemperatureUnit.KELVIN);

        assertEquals(expectedTemp, tempInKelvin);
    }

    @Test
    public void testReturnCelsiusValue_For32Fahrenheit() {
        Measurement<TemperatureUnit> temp = new Temperature(32, TemperatureUnit.FAHRENHEIT);

        Measurement<TemperatureUnit> tempInCelsius = temp.convertTo(TemperatureUnit.CELSIUS);
        Measurement<TemperatureUnit> expectedTemp = new Temperature(0, TemperatureUnit.CELSIUS);

        assertEquals(expectedTemp, tempInCelsius);
    }

    @Test
    public void testReturnKelvinValue_For32Fahrenheit() {
        Measurement<TemperatureUnit> temp = new Temperature(32, TemperatureUnit.FAHRENHEIT);

        Measurement<TemperatureUnit> tempInKelvin = temp.convertTo(TemperatureUnit.KELVIN);
        Measurement<TemperatureUnit> expectedTemp = new Temperature(273.15, TemperatureUnit.KELVIN);

        assertEquals(expectedTemp, tempInKelvin);
    }

    @Test
    public void testReturnCelsiusValue_For273_15Kelvin() {
        Measurement<TemperatureUnit> temp = new Temperature(273.15, TemperatureUnit.KELVIN);

        Measurement<TemperatureUnit> tempInCelsius = temp.convertTo(TemperatureUnit.CELSIUS);
        Measurement<TemperatureUnit> expectedTemp = new Temperature(0, TemperatureUnit.CELSIUS);

        assertEquals(expectedTemp, tempInCelsius);
    }

    @Test
    public void testReturnFahrenheitValue_For273_15Kelvin() {
        Measurement<TemperatureUnit> temp = new Temperature(273.15, TemperatureUnit.KELVIN);

        Measurement<TemperatureUnit> tempInFahrenheit = temp.convertTo(TemperatureUnit.FAHRENHEIT);
        Measurement<TemperatureUnit> expectedTemp = new Temperature(32, TemperatureUnit.FAHRENHEIT);

        assertEquals(expectedTemp, tempInFahrenheit);
    }

    // Increase Temperature

    @Test
    public void testReturnIncreasedCelsius_For1DegreeAnd3_5F(){
        Measurement<TemperatureUnit> temp1 = new Temperature(1, TemperatureUnit.CELSIUS);
        Measurement<TemperatureUnit> temp2 = new Temperature(3, TemperatureUnit.FAHRENHEIT);

        Measurement<TemperatureUnit> sum = ((Temperature) temp1).increaseTemperature((Temperature) temp2);
        Measurement<TemperatureUnit> expectedSum = new Temperature(-15.11111111111111, TemperatureUnit.CELSIUS);

        assertEquals(expectedSum, sum);
    }

    @Test
    public void testReturnIncreasedFahrenheit_For1DegreeAnd5F(){
        Measurement<TemperatureUnit> temp1 = new Temperature(1, TemperatureUnit.CELSIUS);
        Measurement<TemperatureUnit> temp2 = new Temperature(5, TemperatureUnit.FAHRENHEIT);

        Measurement<TemperatureUnit> sum = ((Temperature) temp2).increaseTemperature((Temperature) temp1);
        Measurement<TemperatureUnit> expectedSum = new Temperature(38.8, TemperatureUnit.FAHRENHEIT);

        assertEquals(expectedSum, sum);
    }
}