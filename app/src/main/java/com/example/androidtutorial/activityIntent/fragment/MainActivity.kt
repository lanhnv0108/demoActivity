package com.example.androidtutorial.activityIntent.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.androidtutorial.R
import com.example.androidtutorial.activityIntent.unit.removeFragment
import kotlinx.android.synthetic.main.activity_fragment.*

class MainActivity : AppCompatActivity() /*, InterfaceFragment*/{
    var manager = supportFragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        val transaction  = manager.beginTransaction()
        val fr = FragmentA()
        val fr2 = FragmentB()
//        transaction
//            .replace(R.id.fra , fr)
//            .addToBackStack(FragmentA::class.java.toString())
//            .commit()
//        Log.e(FragmentA.TAG , " On")
////        transaction.replace(R.id.fra, fr)
////        transaction.addToBackStack(null)
////        transaction.commit()

        addFragment(fr , R.id.fra)
        btn_add.setOnClickListener {
            if (btn_add.text == "Delete Fragment"){
                removeFragment(fr2)
                btn_add.text = "Add Fragment"
            }else{
                addFragment(fr2 , R.id.fra2)
                btn_add.text = "Delete Fragment"
            }

        }

        
    }
    private fun AppCompatActivity.addFragment(fragment: Fragment, frameId: Int){
        supportFragmentManager.inTransaction { add(frameId, fragment) }
    }
    private inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> Unit) {
        val fragmentTransaction = beginTransaction()
        fragmentTransaction.func()
        fragmentTransaction.commit()
    }

    /*override fun senData(data: String) {
        (supportFragmentManager.findFragmentById(R.id.fra2) as FragmentB ).getData(data)
    }*/

}