
import classes.*

fun main (args: Array<String>) {
    val uniqueIpAddressCounter = UniqueIpAddressCounter();
    val count = uniqueIpAddressCounter.countUniqueIpAddressInFile("test.txt");
    println(count);
}
