package com.ubb.sensorapp

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.time.LocalDateTime
import kotlin.random.Random

object UploadMockData {
    private val humidityReference = Firebase.database.getReference("humidity")
    private val lightReference = Firebase.database.getReference("light")
    private val temperatureReference = Firebase.database.getReference("temperature")

    fun createAndUpload() {
        Firebase.database.getReference("humidity").setValue("")
        Firebase.database.getReference("light").setValue("")
        Firebase.database.getReference("temperature").setValue("")

        for (year in 2017..2019) {
            for (month in 1..12) {
                for (day in 1..28) {
                    val humidityValue = Random.nextInt(100).toFloat()
                    upload(humidityReference, LocalDateTime.of(year, month, day, 0, 0), humidityValue)
                    val lightValue = Random.nextInt(300).toFloat()
                    upload(lightReference, LocalDateTime.of(year, month, day, 0, 0), lightValue)
                    val temperatureValue = Random.nextInt(30).toFloat()
                    upload(temperatureReference, LocalDateTime.of(year, month, day, 0, 0), temperatureValue)
                }
            }
        }

        val year = 2020
        for (month in 1..4) {
            for (day in 1..28) {
                val humidityValue = Random.nextInt(100).toFloat()
                upload(humidityReference, LocalDateTime.of(year, month, day, 0, 0), humidityValue)
                val lightValue = Random.nextInt(300).toFloat()
                upload(lightReference, LocalDateTime.of(year, month, day, 0, 0), lightValue)
                val temperatureValue = Random.nextInt(30).toFloat()
                upload(temperatureReference, LocalDateTime.of(year, month, day, 0, 0), temperatureValue)
            }
        }
    }

    private fun upload(databaseReference: DatabaseReference, time: LocalDateTime, value: Float?) {
        var key = databaseReference.push().key
        if (key == null) {
            key = ""
        }
        databaseReference.child(key).child("date").setValue(time)
        databaseReference.child(key).child("value").setValue(value)
    }
}