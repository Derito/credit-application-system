package com.helder.credit.aplication.system.dto.request

import com.helder.credit.aplication.system.entity.Customer
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal

data class CustomerUpdateDTO(
    @field:NotEmpty(message = "Invalid Imput! Empty") val firstName: String,
    @field:NotEmpty(message = "Invalid Imput! Empty")  val lastName: String,
    @field:NotNull(message = "Invalid imput! Null") val income: BigDecimal,
    @field:NotEmpty(message = "Invalid Imput! Empty") val zipCode: String,
    @field:NotEmpty(message = "Invalid Imput! Empty") val street: String

) {
    fun toEntity(customer: Customer): Customer{
        customer.firstName = this.firstName
        customer.lastName = this.lastName
        customer.income = this.income
        customer.address.street = this.street
        customer.address.zipCode = this.zipCode

        return customer
    }
}
