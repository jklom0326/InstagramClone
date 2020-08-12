package com.example.instagramclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.*

class LoginMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loginmain)

        lateinit var Button1: Button // 회원가입 버튼
        lateinit var Button2: Button // 로그인 버튼

        Button1 = findViewById(R.id.button1)
        Button2 = findViewById(R.id.button2)

        Button1.setOnClickListener{
            val intent =Intent(applicationContext, RegisterActivity::class.java)
            startActivity(intent)
        }
        Button2.setOnClickListener {
            val intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
        }

//        val provider = arrayListOf(
//            AuthUI.IdpConfig.EmailBuilder().build(),
//            AuthUI.IdpConfig.PhoneBuilder().build(),
//            AuthUI.IdpConfig.FacebookBuilder().build()
//        )

//        startActivityForResult(
//            AuthUI.getInstance()
//                .createSignInIntentBuilder()
//                .setAvailableProviders(provider)
//                .build(),
//            RC_SIGN_IN
//        )
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        if (requestCode == RC_SIGN_IN){
//            val response = IdpResponse.fromResultIntent(data)
//
//            if (resultCode == Activity.RESULT_OK) {
//                // 로그인 성공 했을 때
//                val user = FirebaseAuth.getInstance().currentUser
//
//            }else{
//                // 로그인 실패 했을 때
//            }
//        }
//    }
//    companion object {
//        private const val RC_SIGN_IN = 1001
//    }
}