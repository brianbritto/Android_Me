package pe.portfolio.android.android_me.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import pe.portfolio.android.android_me.R
import pe.portfolio.android.android_me.data.AndroidImageAssets

class AndroidMeActivity : AppCompatActivity() {

    private val TAG : String = "AndroidMeActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android_me)

        if (savedInstanceState == null) {

            val headFragment = BodyPartFragment()
            headFragment.setImageIds(AndroidImageAssets.getHeads())
            headFragment.setListIndex(1)

            val bodyFragment = BodyPartFragment()
            bodyFragment.setImageIds(AndroidImageAssets.getBodies())
            headFragment.setListIndex(1)

            val legFragment = BodyPartFragment()
            legFragment.setImageIds(AndroidImageAssets.getLegs())
            legFragment.setListIndex(1)

            val fragmentManager = supportFragmentManager
            fragmentManager.beginTransaction()
                    .add(R.id.head_container, headFragment)
                    .add(R.id.body_container, bodyFragment)
                    .add(R.id.leg_container, legFragment)
                    .commit()
        } else{
            Log.v(TAG, savedInstanceState.toString())
        }
    }
}