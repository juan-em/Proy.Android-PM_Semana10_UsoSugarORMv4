package com.miempresa.usosugarormv4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* Primera parte para iniciar la actividad
        btnAgregar.setOnClickListener(){
            val intent = Intent(this, RegistroUsuarios::class.java)
            startActivity(intent)
        }*/

        lista.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        lista.layoutManager = LinearLayoutManager(this)

        var usuariorepo = UsuarioRepositorio()
        var listaUsuarios = usuariorepo.listar()

        //obtenemos lista de datos guardados en sugar ORM
        val adapter = AdaptadorUsuarios(listaUsuarios as ArrayList<Usuario>)
        lista.adapter = adapter

        btnAgregar.setOnClickListener(){
            var createUsuario = Intent(this,RegistroUsuarios::class.java)
            startActivity(createUsuario)
        }
    }

    override fun onRestart() {
        super.onRestart()
        var usuariorepo = UsuarioRepositorio()
        var listaUsuarios = usuariorepo.listar()

        val adapter = AdaptadorUsuarios(listaUsuarios as ArrayList<Usuario> )
        lista.adapter = adapter
    }
}