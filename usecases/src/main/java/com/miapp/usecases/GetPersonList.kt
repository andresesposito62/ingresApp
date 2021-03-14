package com.miapp.usecases

import com.miapp.data.PersonsRepository
import com.miapp.domain.Person

class GetPersonList(private val personsRepository: PersonsRepository) {
    //operator fun invoke(): List<Person> = personsRepository.getSavedPersons()
}