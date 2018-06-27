package pe.portfolio.android.android_me.ui

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import pe.portfolio.android.android_me.R
import pe.portfolio.android.android_me.data.AndroidImageAssets

class MasterListFragment : Fragment() {

    lateinit var mCallback:OnImageClickListener

    interface OnImageClickListener{
        fun onImageSelected(position:Int)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        try {
            mCallback = context as OnImageClickListener
        }catch (e:ClassCastException){
            throw ClassCastException("${context.toString()} must implement OnImageClickListener")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val rootView = inflater.inflate(R.layout.fragment_master_list, container, false)
        val gridView = rootView.findViewById(R.id.images_grid_view) as GridView

        val mAdapter = MasterListAdapter(context!!, AndroidImageAssets.getAll())
        gridView.adapter = mAdapter

        gridView.setOnItemClickListener { adapterView, view, position, l ->
            mCallback.onImageSelected(position)
        }

        return rootView
    }
}