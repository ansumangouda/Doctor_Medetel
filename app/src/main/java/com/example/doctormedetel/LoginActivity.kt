package com.example.doctormedetel

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.View.OnClickListener
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.doctormedetel.ResponceClass.LoginResponce
import com.example.doctormedetel.RetrofitNetwork.Retroit
import com.example.doctormedetel.repository.LoginRepository
import com.example.doctormedetel.shared_preferences.SharedPreferences
import com.example.doctormedetel.viewModel.UserViewModel
import com.example.doctormedetel.viewModelFactory.LoginViewFactory


class LoginActivity : AppCompatActivity() {
    private lateinit var etUsername: EditText
    private lateinit var etpassword: EditText
    private lateinit var loginbtn: TextView
    private lateinit var  viewModel :UserViewModel

    override fun onStart() {
        super.onStart()
       // viewModel.fetchUser()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindViews()
        setDummyData()

        val loginTextWatcher = LoginTextWatcher(etUsername, etpassword, loginbtn, this)
        etUsername.addTextChangedListener(loginTextWatcher)

        val loginRepository = LoginRepository(Retroit.apiService,this)
        val loginFactory = LoginViewFactory(loginRepository)
        viewModel = ViewModelProvider(this,loginFactory)[UserViewModel ::class.java]

        val loginListener = Listener(this,viewModel,etUsername,etpassword)
        loginbtn.setOnClickListener(loginListener)

        observeViewModel()



    }
    @SuppressLint("SetTextI18n")
    private fun setDummyData(){
        etUsername.setText("6301712311")
        etpassword.setText("Admin@123")
    }
    private fun renderLoginUI(data: LoginResponce?) {
        data?.let {
            // Perform UI updates based on the login response
            Toast.makeText(this,"Login Successful !",Toast.LENGTH_SHORT).show();
            val sharedPreferences = SharedPreferences(this)
            sharedPreferences.saveAccessToken(it.access_token)
            sharedPreferences.saveEmail(it.emailId )

        }
    }
    private fun observeViewModel() {
        viewModel.loginResponse.observe(this) { loginResponse ->
            if (loginResponse != null) {
                renderLoginUI(loginResponse)
                // Navigate to the next activity
                val intent = Intent(this,DashboardActivity ::class.java)
                startActivity(intent)
            }
        }
    }

    private fun bindViews() {
        etUsername = findViewById(R.id.usernameEt)
        etpassword = findViewById(R.id.passwordET)
        loginbtn = findViewById(R.id.loginBtn)
    }
}
class Listener(
    private val activity: LoginActivity,
    private val viewModel: UserViewModel,
    val etUsername: EditText,
    val etpassword: EditText
) : OnClickListener {
    override fun onClick(v: View?) {
        if (v != null) {
            if (v.id == R.id.loginBtn) {
               val user =  etUsername.text.toString().trim()
                val password = etpassword.text.toString().trim()
                val clientId ="Global_spa"
                val grantType ="phone_number_token"
                val clientSecret ="secret"
                val role ="Doctor (Online)"
                println("totext ${user}")
                    // Toast.makeText(activity, etUsername, Toast.LENGTH_SHORT).show()
                viewModel.accessRepo(user,password,clientId,grantType,clientSecret,role)
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
                if (it.hashCode() == userName.text.hashCode()) {
                    true
                } else {
                    false
                } -> {
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




