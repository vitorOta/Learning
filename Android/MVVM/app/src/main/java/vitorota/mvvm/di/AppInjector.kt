package vitorota.mvvm.di

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
import vitorota.mvvm.MVVMApplication

class AppInjector private constructor() {

    companion object {
        fun init(mvvmApplication: MVVMApplication){
            DaggerAppComponent.builder().application(mvvmApplication)
                .build().inject(mvvmApplication)

            mvvmApplication.registerActivityLifecycleCallbacks(
                object: Application.ActivityLifecycleCallbacks {
                    override fun onActivityPaused(activity: Activity?) {
                    }

                    override fun onActivityResumed(activity: Activity?) {
                    }

                    override fun onActivityStarted(activity: Activity?) {
                    }

                    override fun onActivityDestroyed(activity: Activity?) {
                    }

                    override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {
                    }

                    override fun onActivityStopped(activity: Activity?) {
                    }

                    override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
                        handleActivity(activity!!)
                    }

                }
            )
        }

        fun handleActivity(activity: Activity){
            if(activity is HasSupportFragmentInjector){
                AndroidInjection.inject(activity)
            }

            if (activity is androidx.fragment.app.FragmentActivity) {
                activity.supportFragmentManager.registerFragmentLifecycleCallbacks(
                    object: androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks() {
                        override fun onFragmentCreated(fm: androidx.fragment.app.FragmentManager, f: androidx.fragment.app.Fragment, savedInstanceState: Bundle?) {
                            if (f is Injectable) {
                                AndroidSupportInjection.inject(f)
                            }

                        }
                    }, true
                )
            }


        }
    }
}