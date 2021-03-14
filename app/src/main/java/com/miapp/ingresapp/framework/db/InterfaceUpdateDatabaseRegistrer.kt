package com.miapp.ingresapp.framework.db

import android.content.Context
import com.miapp.domain.Person

interface InterfaceUpdateDatabaseRegistrer {
    fun actualizarPersona(persona: Person, context: Context): Long
}