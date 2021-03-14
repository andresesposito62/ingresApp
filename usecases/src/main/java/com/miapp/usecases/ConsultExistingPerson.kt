package com.miapp.usecases

import com.miapp.data.PersonsRepository
import com.miapp.domain.Person

class ConsultExistingPerson(private val personsRepository: PersonsRepository) {
    operator fun invoke(person: Person?): Person? = personsRepository.readPerson(person)
}