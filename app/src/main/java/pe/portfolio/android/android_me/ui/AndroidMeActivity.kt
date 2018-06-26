package pe.portfolio.android.android_me.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import pe.portfolio.android.android_me.R

class AndroidMeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android_me)

        val headFragment = BodyPartFragment()

        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction()
                .add(R.id.head_container, headFragment)
                .commit()
    }
}