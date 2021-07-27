package com.miapp.usecases

import com.miapp.data.repositories.PersonsRepository

class GetPersonList(private val personsRepository: PersonsRepository) {
    //operator fun invoke(): List<Person> = personsRepository.getSavedPersons()
}