package interview.cinema.service;

import java.util.Iterator;

public interface ElevationCalculator {
    public int calculateElevation(Iterator<Integer> iterator) throws ElevationCalculatorImpl.ElevationCalculationException;
}
