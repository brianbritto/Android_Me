package pe.portfolio.android.android_me.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import pe.portfolio.android.android_me.R
import pe.portfolio.android.android_me.data.AndroidImageAssets

class BodyPartFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_body_part,container,false)
        val imageView = rootView.findViewById(R.id.body_part_image_view) as ImageView
        imageView.setImageResource(AndroidImageAssets.getHeads()[0])
        return rootView
    }
}