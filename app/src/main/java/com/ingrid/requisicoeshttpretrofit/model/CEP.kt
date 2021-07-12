package com.ingrid.requisicoeshttpretrofit.model

class CEP {
    private lateinit var cep:String
    private lateinit var logradouro:String
    private lateinit var complemento:String
    private lateinit var bairro:String
    private lateinit var localidade:String
    private lateinit var uf:String


    fun getCep():String {
        return cep;
    }


   fun getLogradouro():String {
        return logradouro;
    }

    fun getComplemento():String {
        return complemento;
    }

   fun getBairro():String {
        return bairro;
    }


    fun getLocalidade():String {
        return localidade;
    }


   fun getUf():String {
        return uf;
    }

}
