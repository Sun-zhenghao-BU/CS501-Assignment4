package com.example.accelerometer


class SigMove {

    private fun truncateToThreeDecimalPlaces(value: Float): Float {

        return (value * 1000.0f).toInt() / 1000.0f
    }

    fun isSignificantMovement(x: Float, y: Float, z: Float, senseVal: Float): Boolean {
        val truncatedX = truncateToThreeDecimalPlaces(x)
        val truncatedY = truncateToThreeDecimalPlaces(y)
        val truncatedZ = truncateToThreeDecimalPlaces(z)
        val truncatedSenseVal = truncateToThreeDecimalPlaces(senseVal)

        return Math.abs(truncatedX) > truncatedSenseVal ||
                Math.abs(truncatedY) > truncatedSenseVal ||
                Math.abs(truncatedZ) > truncatedSenseVal
    }


}