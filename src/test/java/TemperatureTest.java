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
        Temperature temp = new Temperature(1, TemperatureUnit.CELSIUS);

        Temperature tempInFahrenheit = temp.convertTo(TemperatureUnit.FAHRENHEIT);
        Temperature expectedTemp = new Temperature(33.8, TemperatureUnit.FAHRENHEIT);

        assertEquals(expectedTemp, tempInFahrenheit);
    }

    @Test
    public void testReturnKelvinValue_For1Celsius() {
        Temperature temp = new Temperature(1, TemperatureUnit.CELSIUS);

        Temperature tempInKelvin = temp.convertTo(TemperatureUnit.KELVIN);
        Temperature expectedTemp = new Temperature(274.15, TemperatureUnit.KELVIN);

        assertEquals(expectedTemp, tempInKelvin);
    }

    @Test
    public void testReturnCelsiusValue_For32Fahrenheit() {
        Temperature temp = new Temperature(32, TemperatureUnit.FAHRENHEIT);

        Temperature tempInCelsius = temp.convertTo(TemperatureUnit.CELSIUS);
        Temperature expectedTemp = new Temperature(0, TemperatureUnit.CELSIUS);

        assertEquals(expectedTemp, tempInCelsius);
    }

    @Test
    public void testReturnKelvinValue_For32Fahrenheit() {
        Temperature temp = new Temperature(32, TemperatureUnit.FAHRENHEIT);

        Temperature tempInKelvin = temp.convertTo(TemperatureUnit.KELVIN);
        Temperature expectedTemp = new Temperature(273.15, TemperatureUnit.KELVIN);

        assertEquals(expectedTemp, tempInKelvin);
    }

    @Test
    public void testReturnCelsiusValue_For273_15Kelvin() {
        Temperature temp = new Temperature(273.15, TemperatureUnit.KELVIN);

        Temperature tempInCelsius = temp.convertTo(TemperatureUnit.CELSIUS);
        Temperature expectedTemp = new Temperature(0, TemperatureUnit.CELSIUS);

        assertEquals(expectedTemp, tempInCelsius);
    }

    @Test
    public void testReturnFahrenheitValue_For273_15Kelvin() {
        Temperature temp = new Temperature(273.15, TemperatureUnit.KELVIN);

        Temperature tempInFahrenheit = temp.convertTo(TemperatureUnit.FAHRENHEIT);
        Temperature expectedTemp = new Temperature(32, TemperatureUnit.FAHRENHEIT);

        assertEquals(expectedTemp, tempInFahrenheit);
    }

//    Increase Temperature

    @Test
    public void testReturnIncreasedCelsius_For1DegreeAnd3_5F(){
        Temperature temp1 = new Temperature(1, TemperatureUnit.CELSIUS);
        Temperature temp2 = new Temperature(3, TemperatureUnit.FAHRENHEIT);

        Temperature sum = temp1.increaseTemperature(temp2);
        Temperature expectedSum = new Temperature(-15.11111111111111, TemperatureUnit.CELSIUS);

        assertEquals(expectedSum, sum);
    }

    @Test
    public void testReturnIncreasedFahrenheit_For1DegreeAnd5F(){
        Temperature temp1 = new Temperature(1, TemperatureUnit.CELSIUS);
        Temperature temp2 = new Temperature(5, TemperatureUnit.FAHRENHEIT);

        Temperature sum = temp2.increaseTemperature(temp1);
        Temperature expectedSum = new Temperature(38.8, TemperatureUnit.FAHRENHEIT);

        assertEquals(expectedSum, sum);
    }
}