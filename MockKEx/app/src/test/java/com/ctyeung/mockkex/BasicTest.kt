package com.ctyeung.mockkex

import android.location.Address
import io.mockk.every
import io.mockk.mockk
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

//    @MockK
//    private lateinit var addressMock: Address
//    @MockK
//    private lateinit var contactMock: Contact
//    @InjectMockks
//    val user: User = User()

//    @Before
//    fun setUp() = MockkAnnotations.init(this, relaxUnitFun = true)

    @Test
    fun testBasic() {
        val address = mockk<com.ctyeung.mockkex.Address>("address")
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
}