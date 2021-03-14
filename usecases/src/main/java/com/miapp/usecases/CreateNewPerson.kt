package com.miapp.usecases

import com.miapp.data.PersonsRepository
import com.miapp.domain.Person

class CreateNewPerson(private val personsRepository: PersonsRepository) {
    operator fun invoke(person: Person?): Boolean = personsRepository.createPerson(person)
}