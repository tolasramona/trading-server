package com.btcs.recruting.trading.service;

import java.util.Collection;

public interface TradesProviderService
{
    /**
     * @return all the trades for all the clients existing in the system
     */
    Collection<Trade> getAllTrades();
}
