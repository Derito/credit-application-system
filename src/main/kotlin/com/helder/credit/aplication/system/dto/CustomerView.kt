package com.helder.credit.aplication.system.controller

import com.helder.credit.aplication.system.entity.Customer
import java.math.BigDecimal

class CustomerView(
    val firstName: String,
    val lastName: String,
    val cpf: String,
    val income: BigDecimal,
    val email: String,
    val zipCode: String,
    val street: String
) {
    constructor(customer: Customer): this (
        firstName = customer.firstName,
        lastName = customer.lastName,
        cpf = customer.cpf,
        income = customer.income,
        email = customer.email,
        zipCode =customer.address.zipCode,
        street = customer.address.street
    )



}
