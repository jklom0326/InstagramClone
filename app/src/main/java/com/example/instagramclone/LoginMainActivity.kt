package com.example.instagramclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LoginMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loginmain)

        lateinit var Button1: Button
        Button1 = findViewById(R.id.button1)

        Button1.setOnClickListener{
            val intent =Intent(applicationContext, RegisterActivity::class.java)
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