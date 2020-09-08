package com.example.bnccapplication

data class LookUpData (
    val provinceName: String,
    val numberOfPositiveCases: Int=0,
    val numberOfRecoveredCases: Int=0,
    val numberOfDeathCases: Int=0
)