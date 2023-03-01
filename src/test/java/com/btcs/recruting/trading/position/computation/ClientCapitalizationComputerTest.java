package com.btcs.recruting.trading.position.computation;

import static com.btcs.recruting.trading.service.Side.BUY;
import static com.btcs.recruting.trading.service.Side.SELL;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import org.junit.jupiter.api.Test;
import com.btcs.recruting.trading.position.computation.capitalisation.ClientCapitalizationComputer;
import com.btcs.recruting.trading.provider.TradeProvider;
import com.btcs.recruting.trading.service.AssetClass;
import com.btcs.recruting.trading.service.Trade;

class ClientCapitalizationComputerTest
{

    @Test
    public void capitalisation_is_taking_into_account_the_asset_class()
    {
        TradeProvider tradeProvider = mock(TradeProvider.class);
        when(tradeProvider.getTrades()).thenReturn(getTrades());
        ClientCapitalizationComputer clientCapComputer = new ClientCapitalizationComputer(tradeProvider);

        /**
         * The client `jon` has the following trades:
         * | jon        | XPAR;FTE   |      BUY |       10 |        3|      OPTION|    ----> trade capitalisation = 3000
         * | jon        | XLON;GOOG  |      BUY |       10 |       20|      EQUITY|    ----> trade capitalisation = 200
         * | jon        | XLON;GOOG  |     SELL |       10 |       20|    STRATEGY|    ----> trade capitalisation = 0
         * | jon        | XLON;GOOG  |     SELL |       11 |       20|      EQUITY|    ----> trade capitalisation = 220
         */
        assertThat(clientCapComputer.computeClientCapitalization("jon")).isEqualTo(3420);
    }

    /**
     * Returns the trades:
     * | Client Id  | Instrument |     Side |    Price |      Qty| Asset class|
     * | jon        | XPAR;FTE   |      BUY |       10 |        3|      OPTION|
     * | mary       | XLON;GOOG  |      BUY |       10 |        2|      EQUITY|
     * | jon        | XLON;GOOG  |      BUY |       10 |       20|      EQUITY|
     * | ana        | XLON;AAPL  |     SELL |       10 |       20|        BOND|
     * | jon        | XLON;GOOG  |     SELL |       10 |       20|    STRATEGY|
     * | jon        | XLON;GOOG  |     SELL |       11 |       20|      EQUITY|
     */
    private static Collection<Trade> getTrades()
    {
        return Collections.unmodifiableCollection(
            Arrays.asList(new Trade.Builder()
                    .instrumentId("XPAR;FTE")
                    .side(BUY)
                    .class_(AssetClass.OPTION)
                    .clientId("jon")
                    .price(10)
                    .qty(3)
                    .build(),
                new Trade.Builder()
                    .instrumentId("XLON;GOOG")
                    .side(BUY)
                    .class_(AssetClass.EQUITY)
                    .clientId("mary")
                    .price(10)
                    .qty(2)
                    .build(),
                new Trade.Builder()
                    .instrumentId("XLON;GOOG")
                    .side(BUY)
                    .class_(AssetClass.EQUITY)
                    .clientId("jon")
                    .price(10)
                    .qty(20)
                    .build(),
                new Trade.Builder()
                    .instrumentId("XLON;AAPL")
                    .side(SELL)
                    .class_(AssetClass.BOND)
                    .clientId("ana")
                    .price(10)
                    .qty(20)
                    .build(),
                new Trade.Builder()
                    .instrumentId("XLON;GOOG")
                    .side(SELL)
                    .class_(AssetClass.STRATEGY)
                    .clientId("Jon")
                    .price(10)
                    .qty(20)
                    .build(),
                new Trade.Builder()
                    .instrumentId("XLON;GOOG")
                    .side(SELL)
                    .class_(AssetClass.EQUITY)
                    .clientId("Jon")
                    .price(11)
                    .qty(20)
                    .build())
        );
    }
}