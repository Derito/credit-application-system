package com.helder.credit.aplication.system.entity

import com.helder.credit.aplication.system.enumeration.Status
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.math.BigDecimal
import java.time.LocalDate
import java.util.UUID
data class Credit (

    val creditCode:UUID = UUID.randomUUID(),
    val creditValue:BigDecimal= BigDecimal.ZERO,
    val dayFirstInstallment: LocalDate,
    val numberOfInstallment:Int=0,
    val status: Status= Status.IN_PROGRESS,
    val customer: Customer? = null,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id:Long?= null

)
