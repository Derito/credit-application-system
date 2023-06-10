package com.helder.credit.aplication.system.controller

import com.helder.credit.aplication.system.dto.request.CustomerDTO
import com.helder.credit.aplication.system.dto.request.CustomerUpdateDTO
import com.helder.credit.aplication.system.dto.response.CustomerView
import com.helder.credit.aplication.system.entity.Customer
import com.helder.credit.aplication.system.service.ICustomerService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/customers")
class CustomerController(
    private val icustomerService: ICustomerService
) {
    @PostMapping
    fun saveCustomer(@RequestBody @Valid customerDTO: CustomerDTO): ResponseEntity<String> {
        val savedCustomer = this.icustomerService.save(customerDTO.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED)
            .body("Customer ${savedCustomer.email} saved")
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<CustomerView> {
        val customer: Customer = this.icustomerService.findById(id)
        return ResponseEntity.status(HttpStatus.OK).body(CustomerView(customer))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun deleteCustomer(@PathVariable id: Long) = this.icustomerService.delete(id)

    @PatchMapping
    fun updateCustomer(
        @RequestParam(value = "customerId") id: Long,
        @RequestBody @Valid customerUpdateDTO: CustomerUpdateDTO
    ): ResponseEntity<CustomerView> {
        val customer: Customer = this.icustomerService.findById(id)
        val customerToUpdate: Customer = customerUpdateDTO.toEntity(customer)
        val customerUpdated: Customer = this.icustomerService.save(customerToUpdate)
        return ResponseEntity.status(HttpStatus.OK).body(CustomerView(customerUpdated))
    }
}