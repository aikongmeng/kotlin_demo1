package com.arjun.sensorpng

class Java {
    private val privateString: String? = null
    var publicString: String? = null
    internal var string: String? = null
    internal var stringOK = "OK"

    open class Foo {
        companion object {
            var anInt = 11
        }
    }

    internal inner class B : Foo()

    fun foo(fo: Foo) {

        if (fo is B) {
            System.out.printf("sd")
        }
    }

    companion object {
        internal var staticString: String? = null
    }

}
