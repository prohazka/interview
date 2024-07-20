package interview.cinema.service;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ElevationCalculatorImplTest {
    ElevationCalculatorImpl elevationCalculator = new ElevationCalculatorImpl();

    @SneakyThrows
    @ParameterizedTest
    @MethodSource("testSource")
    public void shouldCalculateElevationCorrectly(List<Integer> srcData, Integer expectedResult) {
        Assertions.assertEquals(expectedResult, elevationCalculator.calculateElevation(srcData.iterator()));
    }

    public static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.arguments(Arrays.asList(0, 3, 5), 5),
                Arguments.arguments(Arrays.asList(5, 3, 0), 0),
                Arguments.arguments(Arrays.asList(5, 5, 5), 0),
                Arguments.arguments(Arrays.asList(-5, 5, -5, 5), 20),
                Arguments.arguments(Arrays.asList(-5, 5, null, 5), 10),
                Arguments.arguments(Arrays.asList(-5, 5, -10, null, null, 10, -20, null, null, null, 20), 70),
                Arguments.arguments(Arrays.asList(-5, 5, -10, null, null, 10, -20, null, null, null), 30),
                Arguments.arguments(Arrays.asList(null, null, 10, -20, null, null, null, 20), 40)
        );
    }

    @Test
    public void shouldThrowCorrectExceptionWithNullIterator() {
        Assertions.assertThrows(ElevationCalculatorImpl.ElevationCalculationException.class, () -> {
            elevationCalculator.calculateElevation(null);
        });
    }

    @Test
    public void shouldThrowCorrectExceptionWithIntegerOverflow() {
        Assertions.assertThrows(ElevationCalculatorImpl.ElevationCalculationException.class, () -> {
            elevationCalculator.calculateElevation(Arrays.asList(Integer.MIN_VALUE, Integer.MAX_VALUE).iterator());
        });
    }
}
