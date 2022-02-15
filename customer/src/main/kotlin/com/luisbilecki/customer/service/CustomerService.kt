package com.luisbilecki.customer.service

import com.luisbilecki.customer.model.Customer
import org.springframework.stereotype.Service

@Service
class CustomerService {

    companion object {
        val customers = mutableListOf<Customer>()
    }

    fun findCustomer(cpf: String): Customer? = customers.find { c -> c.cpf == cpf }

    fun listCustomers() = customers

    fun createCustomer(customer: Customer) = customers.add(customer)
}