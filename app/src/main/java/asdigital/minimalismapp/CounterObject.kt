package asdigital.minimalismapp


object MyCounter {

    //PRIVATE SETTER
    private var counterOne: Int = 0
    private var counterTwo: Int = 0

    fun increaseCounterOne(): Int {
        counterOne++
        return counterOne
    }

    fun increaseCounterTwo(): Int {
        counterTwo++
        return counterTwo
    }

    // GETTERS
    fun getIncreaseCounterOne(): Int {
        return counterOne
    }
    fun getIncreaseCounterTwo(): Int {
        return counterTwo
    }
}