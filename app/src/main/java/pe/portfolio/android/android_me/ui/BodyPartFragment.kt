package pe.portfolio.android.android_me.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import pe.portfolio.android.android_me.R

class BodyPartFragment : Fragment() {

    val IMAGE_ID_LIST = "image_ids"
    val LIST_INDEX = "list_index"

    private val TAG : String = "BodyPartFragment"
    private var mImageIds : ArrayList<Int>? = null
    private var mListIndex : Int = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        if (savedInstanceState != null){
            mImageIds = savedInstanceState.getIntegerArrayList(IMAGE_ID_LIST)
            mListIndex = savedInstanceState.getInt(LIST_INDEX)
        }

        val rootView = inflater.inflate(R.layout.fragment_body_part,container,false)
        val imageView = rootView.findViewById(R.id.body_part_image_view) as ImageView

        if (mImageIds != null){
            imageView.setImageResource(mImageIds!![mListIndex])
            imageView.setOnClickListener{
                if (mListIndex < mImageIds!!.size - 1){
                    mListIndex++
                } else{
                    mListIndex = 0
                }
                imageView.setImageResource(mImageIds!![mListIndex])
            }
        }else{
            Log.v(TAG, "This fragment has a null list of image id's")
        }
        return rootView
    }

    fun setImageIds(imageIds:ArrayList<Int>){
        mImageIds = imageIds
    }

    fun setListIndex(index:Int){
        mListIndex = index
    }

    override fun onSaveInstanceState(currentState: Bundle) {
        currentState.putIntegerArrayList(IMAGE_ID_LIST, mImageIds as ArrayList<Int>)
        currentState.putInt(LIST_INDEX, mListIndex)
    }
}