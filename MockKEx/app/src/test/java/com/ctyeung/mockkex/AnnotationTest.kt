package com.ctyeung.mockkex

import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.SpyK
import io.mockk.mockk
import io.mockk.spyk
import org.junit.Assert.assertEquals
import org.junit.Test

class AnnotationTest {

    @SpyK
    lateinit var address1:Address

    @MockK
    lateinit var address2:Address

    @Test
    fun testCase1() {
        address2 = mockk()
        address1 = spyk(Address("street",
                                "city",
                                "zip",
                                "state"))

        val dis = address1.distance(address2)
        assertEquals(1, dis)
    }
}