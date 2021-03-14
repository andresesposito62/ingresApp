package com.miapp.ingresapp.ui.createperson

import android.content.Context
import com.miapp.domain.Person

class CreateRegistrerInteractor {

    fun queryToDataBase(persona: Person, context: Context): Boolean{
        var status = false
        var implementInterfaceCreateDatabaseRegistrer = ImplementInterfaceCreateDatabaseRegistrer()
        var  affectedRegistrers = implementInterfaceCreateDatabaseRegistrer.registrarPersona(persona, context)

        if(affectedRegistrers!= -1L){
            status = true
        }else{
            status = false
        }
        return status
    }
}