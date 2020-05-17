package com.ubb.sensorapp

import com.google.firebase.database.DatabaseReference
import java.time.LocalDateTime

object UploadUtil {
    fun upload(databaseReference: DatabaseReference, currentValueReference: DatabaseReference, value: Float?) {
        currentValueReference.child("value").setValue(value)
        var key = databaseReference.push().key
        if (key == null) {
            key = ""
        }
        databaseReference.child(key).child("date").setValue(LocalDateTime.now())
        databaseReference.child(key).child("value").setValue(value)
    }
}