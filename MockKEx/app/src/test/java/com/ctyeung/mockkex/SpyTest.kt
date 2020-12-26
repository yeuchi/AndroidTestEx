package com.ctyeung.mockkex

import io.mockk.confirmVerified
import io.mockk.spyk
import io.mockk.verify
import org.junit.Test

class SpyTest {

    @Test
    fun testSpy() {
        val address1 = spyk(Address("street",
                                     "city",
                                      "zip",
                                    "state"))
        val address2 = spyk(Address("street",
                                      "city",
                                       "zip",
                                     "state"))

        // spy allows real distance returned
        val distance = address1.distance(address2)
        verify { address1.distance(address2) }
        confirmVerified(address1)
    }
}