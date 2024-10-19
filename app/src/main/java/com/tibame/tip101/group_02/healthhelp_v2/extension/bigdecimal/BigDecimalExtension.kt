package com.tibame.tip101.group_02.healthhelp_v2.extension.bigdecimal

import java.math.BigDecimal

fun List<BigDecimal>.sum(): BigDecimal {
    var total = BigDecimal.ZERO
    this.forEach{
        total = total.add(it)
    }
    return total
}