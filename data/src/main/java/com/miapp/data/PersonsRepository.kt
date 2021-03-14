package com.miapp.data

import com.miapp.domain.Person

class PersonsRepository (private val personWebSource: PersonWebSource,private val personDeviceSource: PersonDeviceSource){
    fun readPerson() {}
    fun readListPersons(){}
}

//Origenes del repositorio

interface PersonWebSource{
    fun getPerson()
}

interface PersonDeviceSource {
    fun getPerson()
    fun getPersonList(): List<Person>
}