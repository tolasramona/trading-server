package com.btcs.recruting.trading.position.computation.capitalisation.valueprovider;

public class OptionValueProvider implements CapitalizationValueProvider
{
    private static final int MARGIN = 10;

    @Override
    public int computeCapitalisationValue(int qty, int price)
    {
        return qty * price * MARGIN;
    }
}
