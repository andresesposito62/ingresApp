package com.miapp.ingresapp.ui.createperson

import android.content.ContentValues
import android.content.Context
import com.miapp.domain.Person
import com.miapp.ingresapp.framework.db.AdminSQLiteOpenHelper
import com.miapp.ingresapp.framework.db.InterfaceCreateDatabaseRegistrer

class ImplementInterfaceCreateDatabaseRegistrer : InterfaceCreateDatabaseRegistrer {
    override fun registrarPersona(persona: Person, context: Context): Long {
        var registrosAfectados: Long = 0
        //Metodo Registrar
        var identificacion = persona.identification
        var nombres = persona.names
        var apellidos = persona.surnames
        var telefono = persona.phone
        var temperatura = persona.temperature
        var rol = persona.rol
        val admin = AdminSQLiteOpenHelper(context, "administracion12", null, 1)
        val BaseDeDatos = admin.writableDatabase
        if (identificacion != "" && nombres != "" && apellidos != "" && telefono != "" && temperatura != "" &&
                rol != "") {
            var registro = ContentValues()
            registro.put("identificacion", identificacion)
            registro.put("nombres", nombres)
            registro.put("apellidos", apellidos)
            registro.put("telefono", telefono)
            registro.put("temperatura", temperatura)
            registro.put("rol", rol)
            registrosAfectados = BaseDeDatos.insert("personas", null, registro)
            BaseDeDatos.close()
        }
        return registrosAfectados
    }
}