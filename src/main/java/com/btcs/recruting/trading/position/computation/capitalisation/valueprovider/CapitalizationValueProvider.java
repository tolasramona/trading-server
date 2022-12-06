package com.btcs.recruting.trading.position.computation.capitalisation.valueprovider;

public interface CapitalizationValueProvider
{
    int computeCapitalisationValue(int qty, int price);
}
