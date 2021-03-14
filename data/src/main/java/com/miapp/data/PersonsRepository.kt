package com.miapp.data

import com.miapp.domain.Person

class PersonsRepository (private val uiPersonSource: UiPersonSource){

    fun createPerson(person: Person?): Boolean{
        var statusAction : Boolean = false
        if (person != null) {
             statusAction = uiPersonSource.createUiPerson(person)
        }
        return statusAction
    }

    fun readPerson(person: Person?): Person?{
        var personResult : Person? = null
        if (person != null) {
            personResult = uiPersonSource.readUiPerson(person)
        }
        return personResult
    }

    fun updatePerson(person: Person?): Boolean{
        var statusAction : Boolean = false
        if (person != null) {
            statusAction = uiPersonSource.updateUiPerson(person)
        }
        return statusAction
    }

    fun deletePerson(person: Person?): Boolean {
        var statusAction : Boolean = false
        if (person != null) {
            statusAction = uiPersonSource.deleteUiPerson(person)
        }
        return statusAction
    }
}

//Origenes del repositorio
interface UiPersonSource{
    fun createUiPerson(person: Person) : Boolean
    fun readUiPerson(person: Person) : Person
    fun updateUiPerson(person: Person) : Boolean
    fun deleteUiPerson(person: Person) : Boolean
}
