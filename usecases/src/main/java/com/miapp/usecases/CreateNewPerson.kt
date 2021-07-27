package com.miapp.usecases

import com.miapp.data.repositories.PersonsRepository
import com.miapp.domain.Person

class CreateNewPerson(private val personsRepository: PersonsRepository) {
    operator fun invoke(person: Person?): Boolean = personsRepository.createPerson(person)
}