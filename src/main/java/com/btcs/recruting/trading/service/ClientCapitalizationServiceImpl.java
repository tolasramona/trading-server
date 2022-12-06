package com.btcs.recruting.trading.service;

import com.btcs.recruting.trading.position.computation.capitalisation.ClientCapitalizationComputer;
import com.btcs.recruting.trading.provider.TradeProvider;

public class ClientCapitalizationServiceImpl implements ClientCapitalisationService
{
    private final ClientCapitalizationComputer capitalizationComputer;

    public ClientCapitalizationServiceImpl(TradeProvider tradeProvider)
    {
        this.capitalizationComputer = new ClientCapitalizationComputer(tradeProvider);
    }

    @Override
    public int getClientCapitalisation(String clientId)
    {
        return capitalizationComputer.computeClientCapitalization(clientId);
    }
}