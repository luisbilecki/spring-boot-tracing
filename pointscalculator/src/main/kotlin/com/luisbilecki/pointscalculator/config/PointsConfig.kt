package com.luisbilecki.pointscalculator.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConfigurationProperties(prefix = "points")
@ConstructorBinding
data class PointsConfig(val cpp: Int)