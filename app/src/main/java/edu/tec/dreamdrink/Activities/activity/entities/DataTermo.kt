package edu.tec.dreamdrink.Activities.activity.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class DataTermo(

@PrimaryKey(autoGenerate = false)
    val id: String,
    val tapa: String,
    val cilindro: String,
    val tamano: String,
    val precio: Int
): Serializable

data class DataTermoFb(
    val id: String? ="",
    val tapa: String?="",
    val cilindro: String?="",
    val tamano: String?="",
    val precio: Int?= 0
): Serializable
