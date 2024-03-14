package com.example.doctormedetel

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.View.OnClickListener
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


class LoginActivity : AppCompatActivity() {
    private lateinit var etuserNameet: EditText
    private lateinit var passwordet: EditText
    private lateinit var loginbtn: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindViews()
        val loginListener = Listener(this)
        //  loginbtn.setOnClickListener(loginListener)
        val loginTextWatcher = LoginTextWatcher(etuserNameet, passwordet, loginbtn, this)
        etuserNameet.addTextChangedListener(loginTextWatcher)

    }      
    private fun bindViews() {
        etuserNameet = findViewById(R.id.usernameEt)
        passwordet = findViewById(R.id.passwordET)
        loginbtn = findViewById(R.id.loginBtn)
    }
}
class Listener(private val activity: LoginActivity) : OnClickListener {
    override fun onClick(v: View?) {
        if (v != null) {
            if (v.id == R.id.loginBtn) {
                Toast.makeText(activity, "Your message here", Toast.LENGTH_SHORT).show()
            }
        }
    }

}
class LoginTextWatcher(
    private val userName: EditText,
    private val passwordEt: EditText,
    private val loginbtn: TextView,
    private val activity: LoginActivity
) : TextWatcher {
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        s?.let {
            when {
                it.hashCode() == userName.text.hashCode() -> {
                    val userName = it.toString()
                    if (userName.isEmpty()) {
                        Toast.makeText(activity, "how", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
    @SuppressLint("SuspiciousIndentation")
    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        val usernameText = s.toString()
        if (usernameText.length < 2) {
            userName.error = "error"
            //  Toast.makeText(activity, "textChange", Toast.LENGTH_SHORT).show()
            notAccess(loginbtn,activity)
        } else {
            access(loginbtn,activity)
        }
    }
    override fun afterTextChanged(s: Editable?) {
    }

}
fun notAccess(loginBtn: TextView, activity: LoginActivity) {
    loginBtn.isEnabled = false
    loginBtn.error = "null"
    Toast.makeText(activity,"not Access",Toast.LENGTH_SHORT).show()
}
fun access(loginbtn: TextView, activity: LoginActivity) {
    loginbtn.isEnabled = true
    loginbtn.error = null
    Toast.makeText(activity,"Access",Toast.LENGTH_SHORT).show()
}




