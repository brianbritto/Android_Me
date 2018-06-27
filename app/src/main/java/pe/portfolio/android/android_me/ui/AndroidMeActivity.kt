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

            val fragmentManager = supportFragmentManager

            val headFragment = BodyPartFragment()
            headFragment.setImageIds(AndroidImageAssets.getHeads())
            val headIndex = intent.getIntExtra("headIndex",0)
            headFragment.setListIndex(headIndex)
            fragmentManager.beginTransaction()
                    .add(R.id.head_container, headFragment)
                    .commit()

            val bodyFragment = BodyPartFragment()
            bodyFragment.setImageIds(AndroidImageAssets.getBodies())
            val bodyIndex = intent.getIntExtra("bodyIndex",0)
            bodyFragment.setListIndex(bodyIndex)
            fragmentManager.beginTransaction()
                    .add(R.id.body_container, bodyFragment)
                    .commit()

            val legFragment = BodyPartFragment()
            legFragment.setImageIds(AndroidImageAssets.getLegs())
            val legIndex = intent.getIntExtra("legIndex",0)// intent.extras["legIndex"] as Int
            legFragment.setListIndex(legIndex)
            fragmentManager.beginTransaction()
                    .add(R.id.leg_container, legFragment)
                    .commit()

            Log.v(TAG, "${intent.extras["legIndex"]}")
            Log.v(TAG, "${intent.getIntExtra("legIndex",0)}")
            Log.v(TAG, "$headIndex, $bodyIndex, $legIndex")
        } else{
            Log.v(TAG, savedInstanceState.toString())
        }
    }
}