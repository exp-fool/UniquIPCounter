package classes

import exceptions.IncorrectIpAddress
import java.io.BufferedReader
import java.io.File

class UniqueIpAddressCounter {
    private val ipAddressData: UniqueIpAddressData = UniqueIpAddressData()

    public fun countUniqueIpAddressInFile(fileName: String): ULong {
        val bufferedReader: BufferedReader = File(fileName).bufferedReader();
        bufferedReader.forEachLine {
            try {
                val ipAddress = IpAddress(it);
                this.ipAddressData.addIpAddress(ipAddress);
            } catch (e: IncorrectIpAddress) {
                println("You have incorrect IPv4 address in file");
            }
        }
        return this.ipAddressData.getUniqueIpAddressCount();
    }
}

