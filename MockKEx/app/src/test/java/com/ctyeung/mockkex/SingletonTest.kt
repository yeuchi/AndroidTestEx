package com.ctyeung.mockkex

import io.mockk.every
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

enum class StateEnum(val index:Int) {
    MA(1),
    MD(2),
    MN(3);
}

class testSingleton {

    @Test
    fun testMockObj() {
        mockkObject(Singleton)
        val sum = Singleton.add(2,2)
        assertEquals(4, sum)
        unmockkAll()
    }

    @Test
    fun testEnumMockObj() {
        mockkObject(StateEnum.MA)
        every { StateEnum.MA.index } returns 5
        assertEquals(5, StateEnum.MA.index)
        unmockkAll()
    }
}