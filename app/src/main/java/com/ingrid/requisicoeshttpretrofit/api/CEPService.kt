package com.ingrid.requisicoeshttpretrofit.api
import com.ingrid.requisicoeshttpretrofit.model.CEP
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CEPService {

   @GET("{cep}/json/")
   fun recuperarCEP(@Path("cep") cep: String): Call<CEP>

}