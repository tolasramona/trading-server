package com.btcs.recruting.trading.position.computation.capitalisation.valueprovider;

import com.btcs.recruting.trading.service.AssetClass;

public class CapitalizationValueProviderFactory
{
    public CapitalizationValueProvider getCapitalizationValueProvider(AssetClass assetClass)
    {
        switch (assetClass)
        {
            case EQUITY:
            case BOND:
                return new EquityValueProvider();
            case OPTION:
                return new OptionValueProvider();
            default:
                return new DefaultValueProvider();
        }
    }
}
