package classes

import java.util.*

class UniqueIpAddressData {
    private val limit: Int = Int.MAX_VALUE / 3 * 2;
    private val firstPart: BitSet = BitSet(limit)
    private val secondPart: BitSet = BitSet(limit)
    private val thirdPart: BitSet = BitSet(limit + 4)
    private var count: ULong = 0u;

    public fun addIpAddress(ipAddress: IpAddress) {
        var ipAddressValue: Long = ipAddress.getLongRepresentation();
        var containerToSave = this.firstPart;
        if (ipAddressValue >= limit && ipAddressValue <= limit.toLong() * 2) {
            containerToSave = this.secondPart;
            ipAddressValue -= limit;
        } else if (ipAddressValue >= limit.toLong() * 2) {
            containerToSave = this.thirdPart;
            ipAddressValue -= limit.toLong() * 2;
        }
        if (!containerToSave.get(ipAddressValue.toInt())) {
            containerToSave.set(ipAddressValue.toInt());
            count++;
        }
    }

    public fun getUniqueIpAddressCount(): ULong {
        return this.count;
    }
}