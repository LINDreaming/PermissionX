package com.permissionx.library

import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

object PermissionX {
    private const val  TAG = "InvisibleFragment"

    fun request(activity: FragmentActivity, vararg permissions:String, callback: PermissionCallback) {

        val fragmentManager = activity.supportFragmentManager
        val existedFragment = fragmentManager.findFragmentByTag(TAG)
        val fragment = if (existedFragment != null) {
            existedFragment as InvisibleFragment
        }else {
            val invisibleFragment = InvisibleFragment()
            fragmentManager.beginTransaction().add(invisibleFragment, TAG).commitNow()
            invisibleFragment
        }
        // * 表示讲一个数据转换成为一个可变长度的参数
        fragment.requestNow(callback,*permissions)
    }
}