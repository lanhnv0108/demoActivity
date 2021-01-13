package com.example.androidtutorial.activityIntent.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import com.example.androidtutorial.R
import com.example.androidtutorial.activityIntent.unit.addFragment
import com.example.androidtutorial.activityIntent.unit.replaceFragment
import kotlinx.android.synthetic.main.fragment_a.*

open class FragmentA : Fragment() {
    companion object {
        const val TAG = "Test"
    }

    private lateinit var listener: InterfaceFragment
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e(TAG, "On Create View")
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        listener = activity as InterfaceFragment
        btn_Send.setOnClickListener {
            //sendData()
            sendInput()
            //senDataBundle()
        }

    }

/*
    override fun onDetach() {
        super.onDetach()
        Log.e(TAG, "On Detach")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e(TAG, "On Attach")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "On Destroy")
    }

    override fun onStop() {
        super.onStop()
        Log.e(TAG, " On Stop")
    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG, "On Resume")
    }
*/


    // For
    private fun sendData() {
        val data = input.text.toString().trim()
        listener.senData(data)
    }

    // Fragment Manager
    private fun sendInput() {
        setFragmentResult("VALUE", Bundle().apply {
            putString("DATA", input.text.toString())
            putString("DATA2" , "hello")
        })
    }



    // Using Argument
    private fun senDataBundle() {
        val bundle = Bundle()
        bundle.putString("DATA" , input.text.toString())
        val fr2 = FragmentB()
        fr2.arguments = bundle
        addFragment(fr2 , R.id.fra2)
    }
}
