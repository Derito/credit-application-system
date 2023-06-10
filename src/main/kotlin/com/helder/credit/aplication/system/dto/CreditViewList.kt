package com.helder.credit.aplication.system.controller

import java.math.BigDecimal
import java.time.LocalDate

data class CreditViewList(
    val creditValue: BigDecimal,
    val dayFirstInstallment: LocalDate,
    val numberOfInstallment:Int,
    val customerId: Long
) {

}
