package com.ctyeung.mockkex

import android.location.Address
import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test

/*
 * mock k basic
 * https://blog.kotlin-academy.com/mocking-is-not-rocket-science-basics-ae55d0aadf2b
 *
 * MockK
 * https://mockk.io/#hierarchical-mocking
 *
 */
class BasicTest {

    @Test
    fun testBasic() {
        val address = mockk<com.ctyeung.mockkex.Address>()
        val user = mockk<User>()
        val contact = mockk<Contact>()

//        every {contact.address} returns address
//        every {contact.user} returns user

        every { address.street } returns "1 Sepulvuda Lane"
        every { address.city } returns "El Segundo"
        every { address.state } returns "CA"
        every { address.zip } returns "90245"

        every { user.name } returns "Han Solo"
        every { user.phone } returns "123-123-1234"

        assertEquals("123-123-1234", user.phone)
        assertEquals("1 Sepulvuda Lane", address.street)
    }

    @Test
    fun testVerify() {
        val address1 = mockk<com.ctyeung.mockkex.Address>()
        val address2 = mockk<com.ctyeung.mockkex.Address>()
        every { address1.distance(address2) } returns 1

        val dis = address1.distance(address2)

        // verify it was called
        verify(exactly = 1) {address1.distance(address2)}

        // make sure all calls covered by verify
        confirmVerified(address1)
    }
}