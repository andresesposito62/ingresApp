package com.miapp.ingresapp.ui.readperson

import android.content.Context
import com.miapp.domain.Person

class ReadRegistrerInteractor {

    fun queryToDataBase(persona: Person, context: Context): Person?{

        var implementsInterfaceReadFromDataBase = ImplementInterfaceReadDatabaseRegistrer()
        var  personaResult = implementsInterfaceReadFromDataBase.readRegistrerFromDataBase(persona, context)

        if(personaResult.getNombres() != "" && personaResult.getApellidos() != "" && personaResult.getTelefono() != ""
                && personaResult.getTemperatura() != "" && personaResult.getRol() != ""){
            return personaResult

        }else{
            return null
        }
    }
}