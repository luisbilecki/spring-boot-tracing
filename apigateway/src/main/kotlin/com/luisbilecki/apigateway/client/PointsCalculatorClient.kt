package com.luisbilecki.apigateway.client

import com.luisbilecki.apigateway.dto.CalculatePointsRequest
import com.luisbilecki.apigateway.dto.CalculatePointsResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient(name = "pointsCalculatorClient", url = "\${pointsCalculatorClient.url}")
interface PointsCalculatorClient {

    @RequestMapping(method = [RequestMethod.POST], value = ["/points"])
    fun calculatePoints(@RequestBody payload: CalculatePointsRequest): CalculatePointsResponse?
}