package com.btcs.recruting.trading.position.computation.capitalisation;

import java.util.Collection;
import java.util.stream.Collectors;
import com.btcs.recruting.trading.provider.TradeProvider;
import com.btcs.recruting.trading.service.Trade;

public class ClientCapitalizationComputer
{
    private final TradeProvider tradeProvider;
    private final CapitalizationComputer capitalizationComputer = new CapitalizationComputer();

    public ClientCapitalizationComputer(TradeProvider tradeProvider)
    {
        this.tradeProvider = tradeProvider;
    }

    /**
     * Computes the capitalisation of a certain client by aggregating its trades.
     * The capitalisation value depends on the asset class of the traded instrument:
     * | Asset class  |    Cap formula       |
     * | EQUITY       | price * qty          |
     * | BOND         | price * qty          |
     * | OPTION       | price * qty * 100    |
     * | STRATEGY     |         0            |
     *
     * @param clientId The identifier of the client for which we compute the capitalization
     * @return an integer representing the capitalisation
     */
    public int computeClientCapitalization(String clientId)
    {
        Collection<Trade> allTrades = tradeProvider.getTrades();
        return capitalizationComputer.computeCapitalizationFrom(getClientTrades(clientId, allTrades));
    }

    private static Collection<Trade> getClientTrades(String clientId, Collection<Trade> allTrades)
    {
        return allTrades.stream().filter(trade -> trade.getClientId().equals(clientId)).collect(Collectors.toList());
    }
}
