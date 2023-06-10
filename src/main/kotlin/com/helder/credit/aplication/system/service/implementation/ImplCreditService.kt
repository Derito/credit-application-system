package com.helder.credit.aplication.system.service.implementation

import com.helder.credit.aplication.system.entity.Credit
import com.helder.credit.aplication.system.exception.BusinessException
import com.helder.credit.aplication.system.repository.CreditRepository
import com.helder.credit.aplication.system.service.ICreditService
import org.springframework.stereotype.Service
import java.util.*

@Service
class ImplCreditService(
    private val creditRepository: CreditRepository,
    private val implCustomerService: ImplCustomerService
) : ICreditService {
    override fun save(credit: Credit): Credit {
        //O ponto de interrogação no customer porque esta nullable e esclamações porque
        credit.apply {
            customer = implCustomerService.findById(credit.customer?.id!!)
        }
        return this.creditRepository.save(credit)
    }
    override fun findAllByCustomer(customerId: Long): List<Credit> =
        this.creditRepository.findAllByCustomerId(customerId)
    override fun findByCreditCode(customerId: Long, creditCode: UUID): Credit {
        val credit: Credit = (this.creditRepository.findByCreditCode(creditCode)
            ?: throw BusinessException("CreditCode not found"))
        return if (credit.customer?.id == customerId) credit else
            throw IllegalArgumentException("Contact Admin")
        /*
        if(credit.customer?.id == customerId){
         return credit
         }else{
         throw RuntimeException("Contact Admin")
         }
         */
    }
}