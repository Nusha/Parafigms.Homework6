import kotlin.random.Random as rnd

fun binarySearch(arr: IntArray, target: Int): Int {
    var low = 0
    var high = arr.size - 1
    while (low <= high) {
        val mid = low + (high - low) / 2
        when {
            arr[mid] == target -> return mid
            arr[mid] < target -> low = mid + 1
            else -> high = mid - 1
        }
    }
    return -1
}

fun main() {
    val arr = IntArray(rnd.nextInt(1, 15)) { rnd.nextInt(0, 100) }.toSet().toIntArray()
    arr.sort()
    println("Исходный сгенерированный массив: ${arr.contentToString()}")
    print("Введите искомое число: ")
    val input = readlnOrNull()
    val target = input?.toIntOrNull()
    if (target != null) {
        val result = binarySearch(arr, target)

        if (result == -1)
            println("Элемент отсутствует в массиве")
        else
            println("Элемент найден с индексом $result")
    } else println("Неправильный ввод")
}


