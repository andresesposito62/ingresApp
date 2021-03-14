package com.miapp.ingresapp.framework.db

import android.content.Context
import com.miapp.domain.Person

interface InterfaceReadDatabaseRegistrer {
    fun readRegistrerFromDataBase(persona: Person, context: Context): Person
}