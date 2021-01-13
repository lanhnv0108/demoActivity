package com.example.androidtutorial.activityIntent.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import com.example.androidtutorial.R
import com.example.androidtutorial.activityIntent.unit.replaceFragment
import kotlinx.android.synthetic.main.fragment_a.*
import kotlinx.android.synthetic.main.fragment_a.txt_name
import kotlinx.android.synthetic.main.fragment_b.*

class FragmentB : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getInput()
//        getDataBundle()

    }

    private fun getDataBundle() {
        txt_name.text = arguments?.getString("DATA")
    }

    fun getData(data: String) {
        txt_name.text = data
    }

    private fun getInput() {
//        setFragmentResultListener("VALUE") { _, bundle ->
////            txt_name.text = bundle.getString("DATA") + bundle.getString("DATA2")
//            (bundle.getString("DATA") + bundle.getString("DATA2")).also {
//                txt_name.text = it
//            }
//
//        }
        setFragmentResultListener("VALUE") { _, bundle ->
//            txt_name.text = bundle.getString("DATA") + bundle.getString("DATA2")
            (bundle.getString("DATA") + bundle.getString("DATA2")).also {
                txt_name.text = it
            }
        }
    }
}
