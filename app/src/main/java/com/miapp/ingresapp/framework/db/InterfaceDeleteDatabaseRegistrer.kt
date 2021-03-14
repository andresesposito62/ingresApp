package com.miapp.ingresapp.framework.db

import android.content.Context
import com.miapp.domain.Person

interface InterfaceDeleteDatabaseRegistrer {
    fun eliminarPersona(persona: Person, context: Context): Long
}