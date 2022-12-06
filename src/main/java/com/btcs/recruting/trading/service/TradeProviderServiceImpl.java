package com.btcs.recruting.trading.service;

import java.util.Collection;
import com.btcs.recruting.trading.provider.TradeProvider;

public class TradeProviderServiceImpl implements TradesProviderService
{
    private final TradeProvider tradesProvider;

    public TradeProviderServiceImpl(TradeProvider tradesProvider)
    {
        this.tradesProvider = tradesProvider;
    }

    @Override
    public Collection<Trade> getAllTrades()
    {
        return tradesProvider.getTrades();
    }
}
