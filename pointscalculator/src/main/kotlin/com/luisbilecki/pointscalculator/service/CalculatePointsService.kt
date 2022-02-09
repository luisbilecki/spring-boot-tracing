package com.luisbilecki.pointscalculator.service

import com.luisbilecki.pointscalculator.config.PointsConfig
import com.luisbilecki.pointscalculator.dto.CalculatePointsRequest
import com.luisbilecki.pointscalculator.dto.CalculatePointsResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CalculatePointsService @Autowired constructor(private val config: PointsConfig)   {

    fun toPoints(request: CalculatePointsRequest): CalculatePointsResponse {
        return CalculatePointsResponse(
            points = (request.price * config.cpp).toInt()
        )
    }
}