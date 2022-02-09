package com.luisbilecki.pointscalculator

import com.luisbilecki.pointscalculator.config.PointsConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication


@SpringBootApplication
@EnableConfigurationProperties(PointsConfig::class)
class PointsCalculatorApplication

fun main(args: Array<String>) {
	runApplication<PointsCalculatorApplication>(*args)
}
