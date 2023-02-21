package com.btcs.recruting.trading.provider;

import static com.btcs.recruting.trading.service.Side.BUY;
import static com.btcs.recruting.trading.service.Side.SELL;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import com.btcs.recruting.trading.service.AssetClass;
import com.btcs.recruting.trading.service.Trade;

public class TradeProvider
{
    public Collection<Trade> getTrades()
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
