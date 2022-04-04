package com.luisbilecki.apigateway.service

import com.luisbilecki.apigateway.client.CustomerClient
import com.luisbilecki.apigateway.client.PointsCalculatorClient
import com.luisbilecki.apigateway.dto.*
import feign.FeignException
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CustomerService {

    @Autowired
    private lateinit var customerClient : CustomerClient

    @Autowired
    private lateinit var pointsClient : PointsCalculatorClient

    private val logger = KotlinLogging.logger {}

    fun createCustomer(customerData: CreateCustomerRequest): Boolean {
        return try {
            customerClient.createCustomer(customerData)
        } catch (e: FeignException) {
            logger.error { "CustomerService.createCustomer - error during creating customer - error: ${e.message}" }
            false;
        }
    }

    fun calculateCustomerPoints(cpf: String, pointsRequest: CalculatePointsRequest): CalculateCustomerPointsResponse? {
        val customer = findCustomer(cpf)
        val pointsResult = calculatePoints(pointsRequest)
        return CalculateCustomerPointsResponse(name = customer?.name ?: "", points = pointsResult?.points ?: 0)
    }

    private fun findCustomer(cpf: String) : CustomerResponse? {
        return try {
            customerClient.getCustomer(cpf)
        } catch(e: FeignException) {
            logger.error { "CustomerService.findCustomer - error during fetch customer data - error: ${e.message}" }
            null;
        }
    }

    private fun calculatePoints(pointsRequest: CalculatePointsRequest) : CalculatePointsResponse? {
        return try {
            pointsClient.calculatePoints(pointsRequest)
        } catch(e: FeignException) {
            logger.error { "CustomerService.calculatePoints - error during calculate points - error: ${e.message}" }
            null;
        }
    }

}