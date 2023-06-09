package com.helder.credit.aplication.system.entity

class Customer (
    var firstName: String= "",
    var lastName: String="",
    val cpf: String,
    var email: String="",
    var password: String="",
    var address: Address= Address(),
    var credit: List<Credit> = mutableListOf(),
    val id: Long? = null

)