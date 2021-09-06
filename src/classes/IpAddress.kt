package classes

import java.lang.StringBuilder
import kotlin.math.pow
import exceptions.*

data class IpAddress(val ipAddress: String) {

    companion object {
        private const val IPv4_REGEX = "\\b(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\b";
    }

    init {
        this.checkIPv4Address()
    }

    public fun getLongRepresentation(): Long {
        var field: StringBuilder = StringBuilder(3);
        var startIndex: Int = 0;
        var result: Long = 0L;
        for (i in 0..2) {
            val spacerPosition = this.ipAddress.indexOf('.', startIndex);
            field.append(this.ipAddress, startIndex, spacerPosition);
            val fieldValue: Int = field.toString().toInt();
            field.setLength(0);
            result += fieldValue * 256.0.pow((3 - i).toDouble()).toLong();
            startIndex = spacerPosition + 1;
        }
        result += this.ipAddress.substring(startIndex).toLong();
        return result;
    }

    private fun checkIPv4Address() {
        if (this.ipAddress.isEmpty()) {
            throw IncorrectIpAddress("Empty string");
        }
        val regex = Regex(IPv4_REGEX);
        if (!this.ipAddress.matches(regex)) {
            throw IncorrectIpAddress("Incorrect IPv4 Address");
        }
    }
}