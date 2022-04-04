package com.luisbilecki.apigateway.client

import com.luisbilecki.apigateway.dto.CreateCustomerRequest
import com.luisbilecki.apigateway.dto.CustomerResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient(name = "customerClient", url = "\${customerClient.url}")
interface CustomerClient {

    @RequestMapping(method = [RequestMethod.GET], value = ["/customers/{cpf}"])
    fun getCustomer(@PathVariable("cpf") cpf: String): CustomerResponse?

    @RequestMapping(method = [RequestMethod.POST], value = ["/customers"])
    fun createCustomer(@RequestBody customerData: CreateCustomerRequest): Boolean
}