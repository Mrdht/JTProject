package error;

import org.coodex.concrete.common.AbstractErrorCodes;

public class ExampleErrorCodes extends AbstractErrorCodes {
    protected final static int BASE = CUSTOM_LOWER_BOUND + 5000;

    public static final int TOO_HARD = BASE + 1;
}