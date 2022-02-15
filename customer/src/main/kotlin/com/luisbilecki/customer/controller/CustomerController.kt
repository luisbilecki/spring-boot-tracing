package com.luisbilecki.customer.controller

import com.luisbilecki.customer.model.Customer
import com.luisbilecki.customer.service.CustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/customers")
class CustomerController {

    @Autowired
    private lateinit var service : CustomerService

    @GetMapping
    fun listCustomers() = service.listCustomers()

    @GetMapping("/{cpf}")
    fun findCustomer(@PathVariable cpf: String) = service.findCustomer(cpf) ?: ResponseEntity.status(HttpStatus.NOT_FOUND).body(null)

    @PostMapping
    fun createCustomer(@RequestBody customer : Customer) = service.createCustomer(customer)
}