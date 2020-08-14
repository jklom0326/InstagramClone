package com.example.instagramclone

import android.content.Intent
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.widget.CheckedTextView
import android.widget.Toast
import com.facebook.AccessToken
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.util.*

class LoginActivity : AppCompatActivity() {
    lateinit var auth : FirebaseAuth
    lateinit var callbackManger : CallbackManager
    lateinit var checkedTextView :CheckedTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
//        printHashKey()
        auth = FirebaseAuth.getInstance()

        callbackManger = CallbackManager.Factory.create()
        checkedTextView = findViewById(R.id.checkedTextView)
        checkedTextView.setOnClickListener {
            facebookLogin()
        }
    }

    fun facebookLogin(){
        LoginManager.getInstance()
            .logInWithReadPermissions(this, Arrays.asList("public_profile","email"))

        LoginManager.getInstance()
            .registerCallback(callbackManger, object : FacebookCallback<LoginResult>{
                override fun onSuccess(loginResult: LoginResult) {
                    handleFacebookAccessToken(loginResult.accessToken)
                }

                override fun onCancel() {
                }

                override fun onError(error: FacebookException?) {
                    Log.e("Callback :: ", "onError : " + error?.stackTrace);
                }

            })
    }

    fun handleFacebookAccessToken(token : AccessToken){
        val credential = FacebookAuthProvider.getCredential(token.token!!)
        auth.signInWithCredential(credential)
            .addOnCompleteListener {
                task ->
                if (task.isSuccessful){
                    moveMainPage(task.result?.user)
                }else{
                    Toast.makeText(this,task.exception?.message,Toast.LENGTH_SHORT).show()
                }
            }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        callbackManger.onActivityResult(requestCode,resultCode,data)
    }

    fun moveMainPage(user:FirebaseUser?){
        if (user != null){
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
//    fun printHashKey() {
//        try {
//            val info: PackageInfo = getPackageManager()
//                .getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES)
//            for (signature in info.signatures) {
//                val md = MessageDigest.getInstance("SHA")
//                md.update(signature.toByteArray())
//                val hashKey = String(Base64.encode(md.digest(), 0))
//                Log.i("TAG", "printHashKey() Hash Key: $hashKey")
//            }
//        } catch (e: NoSuchAlgorithmException) {
//            Log.e("TAG", "printHashKey()", e)
//        } catch (e: Exception) {
//            Log.e("TAG", "printHashKey()", e)
//        }
//    }
}