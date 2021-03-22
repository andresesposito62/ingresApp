package com.miapp.ingresapp.ui.readperson

import android.os.Handler
import com.miapp.domain.Person

class ReadInteractor {
    interface OnReadFinishedListener {
        fun onQueryError()
        fun onSuccess()
    }

    fun queryToDataBase(persona: Person, context: ReadViewModel, onReadFinishedListener: OnReadFinishedListener): Person?{/*

        var implementsInterfaceReadFromDataBase = ImplementInterfaceReadDatabaseRegistrer()
        var  personaResult = implementsInterfaceReadFromDataBase.readRegistrerFromDataBase(persona, context)

        if(personaResult.getNombres() != "" && personaResult.getApellidos() != "" && personaResult.getTelefono() != ""
                && personaResult.getTemperatura() != "" && personaResult.getRol() != ""){
            return personaResult

        }else{
            return null
        }*/

        // Mock login. I'm creating a handler to delay the answer a couple of seconds
        postDelayed(2000) {
            when {
                persona.identification.isNotEmpty() -> onReadFinishedListener.onSuccess()
                else -> onReadFinishedListener.onQueryError()
            }
        }
        return persona
    }

    fun postDelayed(delayMillis: Long, task: () -> Unit) {
        Handler().postDelayed(task, delayMillis)
    }
}