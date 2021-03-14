package com.miapp.usecases

import com.miapp.data.PersonsRepository
import com.miapp.domain.Person

class DeleteExistingPerson(private val personsRepository: PersonsRepository) {
    operator fun invoke(person: Person?): Boolean = personsRepository.deletePerson(person)
}