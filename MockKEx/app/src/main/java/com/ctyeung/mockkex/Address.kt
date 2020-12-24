package com.ctyeung.mockkex

open class Address (var street:String,
                    var city:String,
                    var zip:String,
                    var state:String) {

    fun distance(address:Address):Int {
        return 1
    }
}