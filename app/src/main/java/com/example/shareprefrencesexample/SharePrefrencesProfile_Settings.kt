package com.example.shareprefrencesexample

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.shareprefrencesexample.databinding.ActivityProfileShareprefrencesSettingsBinding

class SharePrefrencesProfile_Settings : AppCompatActivity() {
    private lateinit var binding: ActivityProfileShareprefrencesSettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_shareprefrences_settings)
        binding= ActivityProfileShareprefrencesSettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saveButton1.visibility=View.INVISIBLE


        binding.readButton1.setOnClickListener {
            val sharedPref: SharedPreferences = getSharedPreferences("UserData", Context.MODE_PRIVATE)
            binding.userNameID1.setText(sharedPref.getString("namekey",""))
            binding.userEmailID1.setText(sharedPref.getString("emailKey",""))
            binding.userPhoneID1.setText(sharedPref.getString("phonekey",""))
            binding.userInstituteID1.setText(sharedPref.getString("instituteKey",""))
            binding.userYearID1.setText(sharedPref.getString("yearKey",""))
            binding.userCityID1.setText(sharedPref.getString("cityKey",""))
        }

        binding.deleteButton1.setOnClickListener {
            val preferences: SharedPreferences =
                getSharedPreferences("UserData", Context.MODE_PRIVATE)
            val editor: SharedPreferences.Editor = preferences.edit()
            editor.clear() // Clears all user data
            editor.apply()
            binding.userNameID1.setText("")
            binding.userPhoneID1.setText("")
            binding.userEmailID1.setText("")
            binding.userInstituteID1.setText("")
            binding.userYearID1.setText("")
            binding.userCityID1.setText("")
        }

        binding.updateButton1.setOnClickListener {

            binding.titleText1.text="Update Information"
            binding.saveButton1.visibility=View.VISIBLE
            binding.updateButton1.visibility=View.INVISIBLE

            val sharedPref: SharedPreferences = getSharedPreferences("UserData", Context.MODE_PRIVATE)
            val editor: SharedPreferences.Editor = sharedPref.edit()
            editor.putString("namekey", binding.userNameID1.text.toString())
            editor.putString("phonekey", binding.userPhoneID1.text.toString())
            editor.putString("emailKey", binding.userEmailID1.text.toString())
            editor.putString("instituteKey", binding.userInstituteID1.text.toString())
            editor.putString("yearKey", binding.userYearID1.text.toString())
            editor.putString("cityKey", binding.userCityID1.text.toString())
            editor.apply()
        }


        binding.newButton1.setOnClickListener {
            val preferences: SharedPreferences =
                getSharedPreferences("UserData", Context.MODE_PRIVATE)
            val editor: SharedPreferences.Editor = preferences.edit()
            editor.clear() // Clears all user data
            editor.apply()
            binding.userNameID1.setText("")
            binding.userPhoneID1.setText("")
            binding.userEmailID1.setText("")
            binding.userInstituteID1.setText("")
            binding.userYearID1.setText("")
            binding.userCityID1.setText("")

            startActivity(Intent(this, SharePrefrencesMainActivity::class.java))
        }

        binding.saveButton1.setOnClickListener {
            Toast.makeText(this, "Data Saved Successfully", Toast.LENGTH_SHORT).show()
            binding.titleText1.text="Your Information"
            binding.userNameID1.clearFocus()
            binding.userPhoneID1.clearFocus()
            binding.userEmailID1.clearFocus()
            binding.userInstituteID1.clearFocus()
            binding.userYearID1.clearFocus()
            binding.userCityID1.clearFocus()

        }
    }
}