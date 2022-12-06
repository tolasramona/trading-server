package com.btcs.recruting.trading.service;

public interface ClientCapitalisationService
{
    /**
     * Capitalisation of a client represents the sum of the capitalisation of all the trades of that client
     * The capitalisation of a trade depends on the type of the trade (asset class):
     * <p>
     * | Asset class |Capitalisation Formula|
     * | EQUITY      | price * qty          |
     * | BOND        | price * qty          |
     * | OPTION      | price * qty * 100    |
     * | STRATEGY    | 0                    |
     *
     * @param clientId the id of the client for which we compute the capitalisation
     * @return an integer representing the capitalisation computed with the above formula
     */
    int getClientCapitalisation(String clientId);
}
