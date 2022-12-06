package com.btcs.recruting.trading.position.computation.capitalisation.valueprovider;

public class EquityValueProvider implements CapitalizationValueProvider
{
    @Override
    public int computeCapitalisationValue(int qty, int price)
    {
        return qty * price;
    }
}
