/*
 * Copyright 2015 The gRPC Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.btcs.recruting.trading;

import java.util.logging.Logger;
import com.btcs.recruting.trading.provider.TradeProvider;
import com.btcs.recruting.trading.service.ClientCapitalisationService;
import com.btcs.recruting.trading.service.ClientCapitalizationServiceImpl;
import com.btcs.recruting.trading.service.TradeProviderServiceImpl;
import com.btcs.recruting.trading.service.TradesProviderService;

public class TradingServer
{
    private static final Logger logger = Logger.getLogger(TradingServer.class.getName());
    private static final TradeProvider tradeProvider = new TradeProvider();

    public TradesProviderService getTradeProviderService()
    {
        logger.info("TradesProviderService requested");
        return new TradeProviderServiceImpl(tradeProvider);
    }

    public ClientCapitalisationService getClientCapitalisationService()
    {
        logger.info("ClientCapitalisationService requested");
        return new ClientCapitalizationServiceImpl(tradeProvider);
    }

}
