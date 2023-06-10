package com.helder.credit.aplication.system.controller

import com.helder.credit.aplication.system.dto.request.CreditDTO
import com.helder.credit.aplication.system.dto.response.CreditView
import com.helder.credit.aplication.system.dto.response.CreditViewList
import com.helder.credit.aplication.system.entity.Credit
import com.helder.credit.aplication.system.service.ICreditService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import java.util.stream.Collectors

@RestController
@RequestMapping("/api/credits")
class CreditController(
    private val iCreditService: ICreditService
) {
    @PostMapping
    fun saveCredit(@RequestBody @Valid creditDTO: CreditDTO):ResponseEntity<String> {
        val savedCredit = this.iCreditService.save(creditDTO.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED)
            .body("Credit ${savedCredit.creditValue} - Customer ${savedCredit.customer?.firstName} saved!")
    }

    @GetMapping
    fun findAllByCustomerId(@RequestParam(value = "customerId") customerId: Long): ResponseEntity<List<CreditViewList>> {
     val creditViewList: List<CreditViewList> =  this.iCreditService.findAllByCustomer(customerId).stream()
            .map { credit: Credit -> CreditViewList(credit) }.collect(Collectors.toList())
        return ResponseEntity.status(HttpStatus.OK).body(creditViewList)
    }
    @GetMapping("/{creditCode}")
    fun findByCreditCode(@RequestParam(value = "customerId") customerId: Long,
                         @PathVariable creditCode: UUID
    ):ResponseEntity<CreditView> {
        val credit:Credit = this.iCreditService.findByCreditCode(customerId,creditCode)
        return ResponseEntity.status(HttpStatus.OK).body(CreditView(credit))
    }
}