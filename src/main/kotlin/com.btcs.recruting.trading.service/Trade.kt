package com.btcs.recruting.trading.service


//data class Trade(val clientId: String, val side: Side, val qty: Int, val price: Int, val class_: AssetClass, val instrumentId: String)

enum class Side { BUY, SELL }

enum class AssetClass { EQUITY, STRATEGY, OPTION, FUTURE, BOND }
class Trade private constructor(
    val clientId: String?,
    val side: Side?,
    val qty: Int?,
    val price: Int?,
    val class_: AssetClass?,
    val instrumentId: String?
) {

    data class Builder(
        var clientId: String? = null,
        var side: Side? = null,
        var qty: Int? = null,
        var price: Int? = null,
        var class_: AssetClass? = null,
        var instrumentId: String? = null
    ) {

        fun clientId(clientId: String) = apply { this.clientId = clientId }
        fun instrumentId(instrumentId: String) = apply { this.instrumentId = instrumentId }
        fun side(side: Side) = apply { this.side = side }
        fun qty(qty: Int) = apply { this.qty = qty }
        fun price(price: Int) = apply { this.price = price }
        fun class_(class_: AssetClass) = apply { this.class_ = class_ }

        fun build() = Trade(clientId, side, qty, price, class_, instrumentId)
    }
}