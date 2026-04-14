package com.example.pdm0126.taller1_00012523

data class Question(
    val id: Int,
    val pregunta: String,
    val opciones: List<String>,
    val respuesta: String,
    val datoCurioso: String
)