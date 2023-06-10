package com.helder.credit.aplication.system.dto.request

import com.helder.credit.aplication.system.entity.Address
import com.helder.credit.aplication.system.entity.Customer
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal

data class CustomerDTO(
    @field:NotEmpty(message = "Invalid input! Empty") val firstName: String,
    @field:NotEmpty(message = "Invalid input! Empty") val lastName: String,
    @field:NotEmpty(message = "Invalid input! Empty")
    @field:CPF(message = "Invalid CPF")
    val cpf: String,
    @field:NotNull(message = "Invalid imput! null") val income: BigDecimal,
    @field:NotEmpty(message = "Invalid input! Empty")
    @field:Email(message = "Invalid email")
    val email: String,
    @field:NotEmpty(message = "Invalid input! Empty")
    val password: String,
    @field:NotEmpty(message = "Invalid input! Empty") val zipCode: String,
    @field:NotEmpty(message = "Invalid input! Empty") val street: String

) {
    fun toEntity(): Customer = Customer(
        firstName = this.firstName,
        lastName = this.lastName,
        cpf = this.cpf,
        income = this.income,
        email = this.email,
        password = this.password,
        address = Address(
            zipCode = this.zipCode,
            street = this.street
        )
    )
}
