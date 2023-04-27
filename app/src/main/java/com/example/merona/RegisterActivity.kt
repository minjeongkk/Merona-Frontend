package com.example.merona

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_register.*
import org.json.JSONException
import org.json.JSONObject
import kotlin.reflect.typeOf


class RegisterActivity : AppCompatActivity() {
    val url = "http://10.0.2.2:8080/user/signup"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        //가입하기 버튼 클릭 시 화면 전환
        RegisterButton.setOnClickListener {
//            val stringRequest: StringRequest = object : StringRequest(
//                Method.POST, url,
//                Response.Listener {
//                    Log.d("회원가입 완료", addEmail.toString())
//                    val intent = Intent(this, LoginActivity::class.java)
//                    startActivity(intent)},
//                Response.ErrorListener {
//                    Log.d("회원가입 실패", "ㅠㅠ") }) {
//                @Throws(AuthFailureError::class)
//                override fun getParams(): Map<String, String>? {
//                    val params: MutableMap<String, String> = HashMap()
//                    params["email"] = addEmail.text.toString()
//                    params["name"] = addName.text.toString()
//                    params["password"] = addPwd.text.toString()
//                    params["phoneNumber"] = Input_Phone.text.toString()
//                    Log.d("이거 반환", params.toString())
//
//                    return params
//                }
//            }

            val json = JSONObject()
            json.put("email", ""+addEmail.text.toString())
            json.put("name", ""+addName.text.toString())
            json.put("password", ""+addPwd.text.toString())
            json.put("phoneNumber", ""+Input_Phone.text.toString())

            val jsonRequest = JsonObjectRequest(Request.Method.POST, url, json, Response.Listener { response ->
                val str = response.toString()
                Log.d("TAG","response: $str")
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }, Response.ErrorListener {
                    error ->
                Log.d("Json", json.toString())
                Log.d("회원가입 실패", error.toString())
            })

            val queue = Volley.newRequestQueue(this)
            queue.add(jsonRequest)

        }

        //뒤로가기 버튼 만들기
        val toolbar = findViewById<Toolbar>(R.id.back_login)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.left_arrow)

    }
}