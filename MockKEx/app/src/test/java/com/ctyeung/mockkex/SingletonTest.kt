package com.ctyeung.mockkex

import io.mockk.mockkObject
import io.mockk.unmockkAll
import io.mockk.unmockkObject
import org.junit.Assert.assertEquals
import org.junit.Test

object Singleton {
    fun add(a:Int, b:Int) :Int {
        return a + b
    }
}

class testSingleton {

    @Test
    fun testMockObj() {
        mockkObject(Singleton)
        val sum = Singleton.add(2,2)
        assertEquals(4, sum)
        unmockkAll()
    }
}