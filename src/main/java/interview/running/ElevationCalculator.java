package interview.running;

import java.util.Iterator;

public interface ElevationCalculator {
    int calculateElevation(Iterator<Integer> iterator) throws ElevationCalculatorImpl.ElevationCalculationException;
}
