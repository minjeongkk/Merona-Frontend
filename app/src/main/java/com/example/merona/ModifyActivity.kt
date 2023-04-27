package com.example.merona

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.FragmentManager
import com.example.merona.databinding.ActivityMainBinding
import com.example.merona.databinding.ActivityModifyBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_modify.*
import kotlinx.android.synthetic.main.fragment_user.*

class ModifyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modify)

        //수정완료 버튼 클릭 시 ModifyActivity -> userFragment
        ModifyButton.setOnClickListener {
//            val userFragment = UserFragment()
//            val transaction = supportFragmentManager.beginTransaction()
//            transaction.replace(R.id.modify_layout, userFragment)
//            transaction.addToBackStack(null)
//            transaction.commit()

            //데이터를 저장하는 코드

            //창을 닫아
            onBackPressed();
        }


    }
}