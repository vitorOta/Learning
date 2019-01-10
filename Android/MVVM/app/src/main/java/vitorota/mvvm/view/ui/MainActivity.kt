package vitorota.mvvm.view.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import vitorota.mvvm.R
import vitorota.mvvm.service.model.Project

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, ProjectListFragment.getInstance())
                .commit()
        }
    }
}
