package com.ubb.lightmeter

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.ubb.sensorapp.UploadUtil.upload

class HumiditySensorListener : SensorEventListener {
    private val databaseReference = Firebase.database.getReference("humidity")
    private val currentValueReference = Firebase.database.getReference("humidityCurrentValue")

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }

    override fun onSensorChanged(event: SensorEvent?) {
        val value = event?.values?.get(0)
        upload(databaseReference, currentValueReference, value)
    }

}