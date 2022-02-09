package com.luisbilecki.pointscalculator.controller

import com.luisbilecki.pointscalculator.dto.CalculatePointsRequest
import com.luisbilecki.pointscalculator.dto.CalculatePointsResponse
import com.luisbilecki.pointscalculator.service.CalculatePointsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/points")
class CalculatePointsController {

    @Autowired
    private lateinit var service : CalculatePointsService

    @PostMapping
    fun calculatePoints(@RequestBody request : CalculatePointsRequest) : CalculatePointsResponse = service.toPoints(request)
}