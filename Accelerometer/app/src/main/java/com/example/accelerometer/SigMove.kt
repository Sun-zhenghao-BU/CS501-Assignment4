package com.example.accelerometer


class SigMove {


    fun isSignificantMovement(x: Float, y: Float, z: Float, senseVal:Float): Boolean {
        return Math.abs(x) > senseVal || Math.abs(y) > senseVal || Math.abs(z) > senseVal
    }

}