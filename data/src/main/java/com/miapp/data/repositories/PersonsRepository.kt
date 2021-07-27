package com.miapp.data.repositories

import com.miapp.domain.Person

class PersonsRepository (private val uiPersonSourceForCreateRegistrer: UiPersonSourceForCreateRegistrer,
                         private val uiPersonSourceForReadRegistrer: UiPersonSourceForReadRegistrer,
                         private val uiPersonSourceForUpdateRegistrer: UiPersonSourceForUpdateRegistrer,
                         private val uiPersonSourceForDeleteRegistrer: UiPersonSourceForDeleteRegistrer
){

    fun createPerson(person: Person?): Boolean{
        var statusAction : Boolean = false
        if (person != null) {
             statusAction = uiPersonSourceForCreateRegistrer.createUiPerson(person)
        }
        return statusAction
    }

    fun readPerson(person: Person?): Person?{
        var personResult : Person? = null
        if (person != null) {
            personResult = uiPersonSourceForReadRegistrer.readUiPerson(person)
        }
        return personResult
    }

    fun updatePerson(person: Person?): Boolean{
        var statusAction : Boolean = false
        if (person != null) {
            statusAction = uiPersonSourceForUpdateRegistrer.updateUiPerson(person)
        }
        return statusAction
    }

    fun deletePerson(person: Person?): Boolean {
        var statusAction : Boolean = false
        if (person != null) {
            statusAction = uiPersonSourceForDeleteRegistrer.deleteUiPerson(person)
        }
        return statusAction
    }
}

//Origenes del repositorio
interface UiPersonSourceForCreateRegistrer{
    fun createUiPerson(person: Person) : Boolean
}
interface UiPersonSourceForReadRegistrer{
    fun readUiPerson(person: Person) : Person
}
interface UiPersonSourceForUpdateRegistrer{
    fun updateUiPerson(person: Person) : Boolean
}
interface UiPersonSourceForDeleteRegistrer{
    fun deleteUiPerson(person: Person) : Boolean
}