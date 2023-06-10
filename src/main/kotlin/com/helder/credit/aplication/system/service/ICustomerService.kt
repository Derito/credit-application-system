package com.helder.credit.aplication.system.service

import com.helder.credit.aplication.system.entity.Customer

interface ICustomerService {

    fun save(customer: Customer): Customer

    fun findById(id: Long): Customer

    fun delete(id: Long)


}