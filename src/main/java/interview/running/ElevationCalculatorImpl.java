package interview.running;

import java.math.BigInteger;
import java.util.Iterator;

public class ElevationCalculatorImpl implements ElevationCalculator {
    @Override
    public int calculateElevation(Iterator<Integer> iterator) throws ElevationCalculationException {
        if (iterator == null) {
            throw new ElevationCalculationException("Iterator is null");
        }
        BigInteger intCeiling = BigInteger.valueOf(Integer.MAX_VALUE);
        BigInteger safeElevationCounter = BigInteger.ZERO;
        Integer previousHeight = null;
        while (iterator.hasNext()) {
            Integer height = iterator.next();
            if (height != null) {
                if (previousHeight != null) {
                    BigInteger delta = BigInteger.valueOf(height).subtract(BigInteger.valueOf(previousHeight));
                    if (delta.compareTo(BigInteger.ZERO) > 0) {
                        safeElevationCounter = safeElevationCounter.add(delta);
                        if (safeElevationCounter.compareTo(intCeiling) > 0) {
                            throw new ElevationCalculationException("Integer max value exceeded");
                        }
                    }
                }
                previousHeight = height;
            }
        }
        return safeElevationCounter.intValue();
    }

    static class ElevationCalculationException extends Exception {

        public ElevationCalculationException(String text) {
            super(text);
        }
    }

}
