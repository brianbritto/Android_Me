package pe.portfolio.android.android_me.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.GridView
import android.widget.LinearLayout
import android.widget.Toast
import pe.portfolio.android.android_me.R
import pe.portfolio.android.android_me.data.AndroidImageAssets

class MainActivity : AppCompatActivity(), MasterListFragment.OnImageClickListener {

    private val TAG : String = "MainActivity"

    private var headIndex : Int = 0
    private var bodyIndex : Int = 0
    private var legIndex : Int = 0

    private var mTwoPane : Boolean = false

    override fun onImageSelected(position: Int) {
        Toast.makeText(this,"Position clicked = $position",Toast.LENGTH_SHORT).show()

        val bodyPartNumber = position/12
        val listIndex = position - 12*bodyPartNumber
        Log.v(TAG, "$bodyPartNumber, $listIndex")

        if (mTwoPane){
            val newFragment = BodyPartFragment()
            when(bodyPartNumber){
                0 -> {
                    newFragment.setImageIds(AndroidImageAssets.getHeads())
                    newFragment.setListIndex(listIndex)
                    supportFragmentManager.beginTransaction()
                            .replace(R.id.head_container, newFragment)
                            .commit()
                }
                1 -> {
                    newFragment.setImageIds(AndroidImageAssets.getBodies())
                    newFragment.setListIndex(listIndex)
                    supportFragmentManager.beginTransaction()
                            .replace(R.id.body_container, newFragment)
                            .commit()
                }
                2 -> {
                    newFragment.setImageIds(AndroidImageAssets.getLegs())
                    newFragment.setListIndex(listIndex)
                    supportFragmentManager.beginTransaction()
                            .replace(R.id.leg_container, newFragment)
                            .commit()
                }
            }
        } else {
            when (bodyPartNumber) {
                0 -> headIndex = listIndex
                1 -> bodyIndex = listIndex
                2 -> legIndex = listIndex
            }
            Log.v(TAG, "$headIndex, $bodyIndex, $legIndex")

            val b = Bundle()
            b.putInt("headIndex", headIndex)
            b.putInt("bodyIndex", bodyIndex)
            b.putInt("legIndex", legIndex)
            Log.v(TAG, "${b.getInt("legIndex")}")

            val intent = Intent(this, AndroidMeActivity::class.java)
            intent.putExtras(b)

            val nextButton = findViewById<Button>(R.id.next_button)
            nextButton.setOnClickListener { startActivity(intent) }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (findViewById<LinearLayout>(R.id.android_me_linear_layout) != null){

            mTwoPane = true

            val nextButton = findViewById<Button>(R.id.next_button)
            nextButton.visibility = View.GONE

            val gridView = findViewById<GridView>(R.id.images_grid_view)
            gridView.columnWidth = 2


            if (savedInstanceState == null) {

                val fragmentManager = supportFragmentManager

                val headFragment = BodyPartFragment()
                headFragment.setImageIds(AndroidImageAssets.getHeads())
                fragmentManager.beginTransaction()
                        .add(R.id.head_container, headFragment)
                        .commit()

                val bodyFragment = BodyPartFragment()
                bodyFragment.setImageIds(AndroidImageAssets.getBodies())
                fragmentManager.beginTransaction()
                        .add(R.id.body_container, bodyFragment)
                        .commit()

                val legFragment = BodyPartFragment()
                legFragment.setImageIds(AndroidImageAssets.getLegs())
                fragmentManager.beginTransaction()
                        .add(R.id.leg_container, legFragment)
                        .commit()
            } else{
                Log.v(TAG, savedInstanceState.toString())
            }
        } else {
            mTwoPane = false
        }
    }
}
