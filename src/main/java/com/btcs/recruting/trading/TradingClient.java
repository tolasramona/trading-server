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

import com.btcs.recruting.trading.service.Trade;

/**
 * A simple client that uses different services exposed by the trading server.
 */
public class TradingClient
{
    private static final TradingServer server = new TradingServer();

    public static void main(String[] args)
    {
        showTrades();
        showFormulas();
        showCapitalisation("jon");
        showPortofolioValue("jon");
    }

    private static void showTrades()
    {
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Client trades are: ");
        System.out.printf("| %-10s | %-10s | %8s | %8s | %8s | %8s|%n", "Client Id", "Instrument", "Side", "Price", "Qty", "Asset class");
        server.getTradeProviderService().getAllTrades().forEach(TradingClient::printFormatted);
        System.out.println("-------------------------------------------------------------------");
    }

    private static void printFormatted(Trade trade)
    {
        System.out.printf("| %-10s | %-10s | %8s | %8s | %8s| %8s|%n", trade.getClientId(), trade.getInstrumentId(), trade.getSide(), trade.getPrice(), trade.getQty(), trade.getClass_());
    }

    private static void showFormulas()
    {
        System.out.printf("| %-10s | %-20s |%n", "Asset class", "Capitalization Formula");
        System.out.printf("| %-10s | %-20s |%n", "EQUITY", "price * qty");
        System.out.printf("| %-10s | %-20s |%n", "BOND", "price * qty");
        System.out.printf("| %-10s | %-20s |%n", "OPTION", "price * qty * 100");
        System.out.printf("| %-10s | %-20s |%n", "STRATEGY", "0");
    }

    private static void showCapitalisation(String clientId)
    {
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Client " + clientId + " has capitalization = " + server.getClientCapitalisationService().getClientCapitalisation("jon"));
        System.out.println("-------------------------------------------------------------------");
    }

    private static void showPortofolioValue(String clientId)
    {
        // TODO
    }
}
