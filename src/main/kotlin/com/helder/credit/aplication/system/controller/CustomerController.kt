package com.helder.credit.aplication.system.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/customers")
class CustomerDTO {

    @PostMapping
    fun saveCustomer(customerDto):String {
        
    }
}