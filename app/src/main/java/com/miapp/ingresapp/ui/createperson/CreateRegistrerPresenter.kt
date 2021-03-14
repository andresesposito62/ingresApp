package com.miapp.ingresapp.ui.createperson

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.miapp.domain.Person
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CreateRegistrerPresenter : AppCompatActivity {
    private var createRegistrerView : CreateRegistrerActivity? = null
    private var createRegistrerInteractor : CreateRegistrerInteractor//? = null
    private var context : Context
    private lateinit var person : Person


    constructor(createRegistrerView: CreateRegistrerActivity, createRegistrerInteractor: CreateRegistrerInteractor, context: Context){
        this.createRegistrerView = createRegistrerView
        this.createRegistrerInteractor = createRegistrerInteractor
        this.context = context
    }

    interface CreateRegistrerInterface {
        fun showProgress()
        fun hideProgress()
        fun navigateToActionSelector()
        fun setQueryError()
        fun setValuesEmptyError()
        fun setSucces()
    }

    fun createRegistrer(identification : String, names : String, surnames : String, phone: String,
                        temperature : String, rol : String ){
        if(createRegistrerView != null){
            //  readRegistrerView?.showProgress()
        }

        if(!identification.isEmpty()  && !names.isEmpty()  && !surnames.isEmpty() && !phone.isEmpty()
                && !temperature.isEmpty() && !rol.isEmpty()){
            person  = Person(identification,names,phone,surnames,temperature,rol)
            //createRegistrerInteractor.queryToDataBase(person, context)

            createRegistrerView?.showProgress()
            android.os.Handler().postDelayed({// se pone en un retardo de 2seg simulando una consulta a un servidor externo
                queryToDatabase(person)
            }, 2000)
        }else{
            setEmptyValuesError()
        }
    }

    private fun queryToDatabase(person: Person){//implementacion corrutina
        CoroutineScope(Dispatchers.IO).launch {
            //readRegistrerInteractor.queryToDataBase(person,this@ReadRegistrerPresenter, context)
            val queryResult : Boolean? = createRegistrerInteractor.queryToDataBase(person, context)
            runOnUiThread{//todo lo que este aqui se ejecuta en el hilo principal
                createRegistrerView?.hideProgress()
                if(queryResult != null){
                    createRegistrerView?.setSucces()
                }else{
                    createRegistrerView?.setQueryError()
                }
            }
        }
    }

    fun setEmptyValuesError(){
        createRegistrerView!!.setValuesEmptyError()
    }


}