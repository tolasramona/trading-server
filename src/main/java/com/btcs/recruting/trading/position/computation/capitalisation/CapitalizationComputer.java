package com.btcs.recruting.trading.position.computation.capitalisation;

import java.util.Collection;
import com.btcs.recruting.trading.position.computation.capitalisation.valueprovider.CapitalizationValueProvider;
import com.btcs.recruting.trading.position.computation.capitalisation.valueprovider.CapitalizationValueProviderFactory;
import com.btcs.recruting.trading.service.Trade;

public class CapitalizationComputer
{
    private final CapitalizationValueProviderFactory capValueProviderFactory = new CapitalizationValueProviderFactory();

    public int computeCapitalizationFrom(Collection<Trade> clientTrades)
    {
        // TODO for candidate: refactor this to a more compact form using streams
        int totalCapitalisation = 0;
        for (Trade t : clientTrades)
        {
            CapitalizationValueProvider capitalisationValueProvider = capValueProviderFactory.getCapitalizationValueProvider(t.getClass_());
            int tradeCap = capitalisationValueProvider.computeCapitalisationValue(t.getPrice(), t.getQty());
            totalCapitalisation += tradeCap;
        }
        return totalCapitalisation;
    }
}
