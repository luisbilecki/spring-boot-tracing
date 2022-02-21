package com.luisbilecki.apigateway.service

import com.luisbilecki.apigateway.client.CustomerClient
import com.luisbilecki.apigateway.client.PointsCalculatorClient
import com.luisbilecki.apigateway.dto.CalculateCustomerPointsResponse
import com.luisbilecki.apigateway.dto.CalculatePointsRequest
import com.luisbilecki.apigateway.dto.CalculatePointsResponse
import com.luisbilecki.apigateway.dto.CustomerResponse
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

    fun calculateCustomerPoints(cpf: String, pointsRequest: CalculatePointsRequest): CalculateCustomerPointsResponse? {
        val customer = findCustomer(cpf)
        val pointsResult = calculatePoints(pointsRequest)
        return CalculateCustomerPointsResponse(name = customer?.name ?: "", points = pointsResult?.points ?: 0)
    }

    private fun findCustomer(cpf: String) : CustomerResponse? {
        try {
            return customerClient.getCustomer(cpf)
        } catch(e: FeignException) {
            logger.error { "CustomerService.findCustomer - error during fetch customer data - error: ${e.message}" }
            return null;
        }
    }

    private fun calculatePoints(pointsRequest: CalculatePointsRequest) : CalculatePointsResponse? {
        try {
            return pointsClient.calculatePoints(pointsRequest)
        } catch(e: FeignException) {
            logger.error { "CustomerService.calculatePoints - error during calculate points - error: ${e.message}" }
            return null;
        }
    }

}