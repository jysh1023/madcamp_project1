package com.example.madcamp_project1

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.madcamp_project1.contact.ContactFragment
import com.example.madcamp_project1.gallery.GalleryFragment
import java.lang.RuntimeException

class ViewAdapter(activity: AppCompatActivity): FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> ContactFragment()
            1 -> GalleryFragment()
            2 -> GalleryFragment()  // todo: Tab3Fragment
            else -> throw RuntimeException("Invalid Position : $position")
        }
    }
}
