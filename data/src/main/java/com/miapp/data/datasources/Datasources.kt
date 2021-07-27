package com.miapp.data.datasources

import com.miapp.domain.Person
import io.reactivex.Flowable

interface RemotePersonDataSource{

}

interface LocalPersonDataSource{
    fun getAllPerson():Flowable<List<Person>>
    fun getPersonbyId(): Person
}