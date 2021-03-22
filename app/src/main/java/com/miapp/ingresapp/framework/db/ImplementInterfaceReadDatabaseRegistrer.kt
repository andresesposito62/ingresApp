package com.miapp.ingresapp.framework.db

import android.content.Context
import com.miapp.data.UiPersonSourceForReadRegistrer
import com.miapp.domain.Person

class ImplementInterfaceReadDatabaseRegistrer(private var context: Context) : UiPersonSourceForReadRegistrer {
    override fun readUiPerson(person: Person): Person {
        var identificacion = person.identification
        var admin = AdminSQLiteOpenHelper(context, "administracion12", null, 1)
        var BaseDeDatos = admin.writableDatabase
        if (identificacion != "" ) {
            var fila = BaseDeDatos.rawQuery("select nombres, apellidos, telefono, temperatura, rol from personas where identificacion="+identificacion,null)

            if (fila.moveToFirst()) {
                person.names = fila.getString(0)
                person.surnames = fila.getString(1)
                person.phone = fila.getString(2)
                person.temperature = fila.getString(3)
                person.rol = fila.getString(4)
                person.identification = identificacion
                //consulta exitosa
                BaseDeDatos.close()
            } else {
                //consulta no exitosa
                person.names = ("")
                person.surnames = ("")
                person.phone = ("")
                person.temperature = ("")
                person.rol = ("")
                person.identification = ("")
                BaseDeDatos.close()
            }
        } else {
            //consulta no exitosa
            person.names = ("")
            person.surnames = ("")
            person.phone = ("")
            person.temperature = ("")
            person.rol = ("")
            person.identification = ("")
        }
        return person
    }
}