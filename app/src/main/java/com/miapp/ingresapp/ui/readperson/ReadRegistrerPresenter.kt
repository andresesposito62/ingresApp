package com.miapp.ingresapp.ui.readperson

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.miapp.domain.Person
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ReadRegistrerPresenter : AppCompatActivity {

    private var readRegistrerView : ReadRegistrerActivity? = null
    private var readRegistrerInteractor : ReadRegistrerInteractor//? = null
    private var context : Context
    private lateinit var person : Person
    private var statusQuery : Boolean? = null


    constructor(readRegistrerActivity: ReadRegistrerActivity, readRegistrerInteractor: ReadRegistrerInteractor, context: Context){
        this.readRegistrerView = readRegistrerActivity
        this.readRegistrerInteractor = readRegistrerInteractor
        this.context = context
    }

    interface ReadRegistrerInterface {
        fun showProgress()
        fun hideProgress()
        fun setIdentificationError()
        fun navigateToActionSelector()
        fun setQueryError()
        fun setDates(persona: Person)
        fun setIdentificationEmptyError()
    }


    fun readRegistrer(identification : String, names : String, surnames : String, phone: String,
                      temperature : String, rol : String ){
        if(readRegistrerView != null){
            //  readRegistrerView?.showProgress()
        }

        if(!identification.isEmpty()){
            person.identification
            person.names
            person.phone
            person.surnames
            person.temperature
            person.rol

            readRegistrerView?.showProgress()
            android.os.Handler().postDelayed({// se pone en un retardo de 2seg simulando una consulta a un servidor externo
                queryToDatabase(person)
            }, 2000)

        }else{
            setIdentificationEmptyError()
        }
    }

    private fun queryToDatabase(person: Person){//implementacion corrutina
        CoroutineScope(Dispatchers.IO).launch {
            //readRegistrerInteractor.queryToDataBase(person,this@ReadRegistrerPresenter, context)
            val personResult : Person? = readRegistrerInteractor.queryToDataBase(person, context)
            runOnUiThread{//todo lo que este aqui se ejecuta en el hilo principal
                readRegistrerView?.hideProgress()
                if(personResult != null){
                    readRegistrerView?.setDates(personResult)
                }else{
                    readRegistrerView?.setQueryError()
                }
            }
        }
    }

    fun setIdentificationEmptyError(){
        readRegistrerView!!.setIdentificationEmptyError()
    }
}