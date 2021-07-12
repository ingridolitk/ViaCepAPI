package com.ingrid.requisicoeshttpretrofit

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.ingrid.requisicoeshttpretrofit.api.CEPService
import com.ingrid.requisicoeshttpretrofit.model.CEP
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


private lateinit var btnRecupera: Button
private lateinit var txtResultado: TextView
private lateinit var retrofit: Retrofit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        retrofit = Retrofit.Builder()
            .baseUrl("https://viacep.com.br/ws/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        bindView()
        btnRecupera.setOnClickListener() {
            recuperarCEPRetrofit()
        }

    }

    fun recuperarCEPRetrofit() {
        val cepService: CEPService = retrofit.create(CEPService::class.java)
        var edtCep = findViewById<EditText>(R.id.edtCep)
        cepService.recuperarCEP(edtCep.text.toString()).enqueue(object : Callback<CEP?> {

            override fun onResponse(
                call: Call<CEP?>,
                response: Response<CEP?>,
            ) {
               if (response.isSuccessful()){
                   var cep = response.body()
                   txtResultado.text=(( cep?.getCep()  ) +'-'+  cep?.getLogradouro() + '-'+ (cep?.getBairro()+ '-'
                           + (cep?.getComplemento() +'-'
                      + cep?.getLocalidade() +'/'+ cep?.getUf() )))
               }
            }

            override fun onFailure(call: Call<CEP?>, t: Throwable) {
                Log.e("EnderecoRepository", "onFailure: falha ao buscar o endereço", t)
            }

        })
    }


    private fun bindView() {
        btnRecupera = findViewById(R.id.btnRecupera)
        txtResultado = findViewById(R.id.txtResultado)
    }
}

