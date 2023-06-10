package com.helder.credit.aplication.system.service.implementation

import com.helder.credit.aplication.system.entity.Customer
import com.helder.credit.aplication.system.exception.BusinessException
import com.helder.credit.aplication.system.repository.CustomerRepository
import com.helder.credit.aplication.system.service.ICustomerService
import org.springframework.stereotype.Service

/**
 * Implementação da interface ICustomerService definindo as regras do negócio.
 */
@Service
class ImplCustomerService(
    private val customerRepository: CustomerRepository
) : ICustomerService {
    override fun save(customer: Customer): Customer =
        this.customerRepository.save(customer)

    override fun findById(id: Long): Customer =
        this.customerRepository.findById(id).orElseThrow {
            //Substituindo a RuntimeException por uma personalizada criada Businessexception
            throw BusinessException("id $id not found or not exist")
            //throw RuntimeException("id $id not found")
        }

    override fun delete(id: Long) {
        val customer : Customer = this.findById(id)
        this.customerRepository.delete(customer)
        // = this.customerRepository.findById(id).ifPresent(customerRepository::delete)
        //this.customerRepository.deleteById(id)
    }
}