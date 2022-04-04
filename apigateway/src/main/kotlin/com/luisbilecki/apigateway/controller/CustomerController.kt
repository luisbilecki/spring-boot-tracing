package com.luisbilecki.apigateway.controller

import com.luisbilecki.apigateway.dto.CalculateCustomerPointsResponse
import com.luisbilecki.apigateway.dto.CalculatePointsRequest
import com.luisbilecki.apigateway.dto.CalculatePointsResponse
import com.luisbilecki.apigateway.dto.CreateCustomerRequest
import com.luisbilecki.apigateway.service.CustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/customers")
class CustomerController {

    @Autowired
    private lateinit var service : CustomerService

    @PostMapping("/{cpf}/points")
    fun calculateCustomerPoints(@PathVariable cpf: String, @RequestBody pointsPayload: CalculatePointsRequest) : CalculateCustomerPointsResponse? = service.calculateCustomerPoints(cpf, pointsPayload)

    @PostMapping
    fun createCustomer(@RequestBody customerData: CreateCustomerRequest) = service.createCustomer(customerData)
}