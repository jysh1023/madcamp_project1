package com.example.madcamp_project1.gallery

import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.madcamp_project1.GalleryActivity
import com.example.madcamp_project1.R
import com.example.madcamp_project1.databinding.FragmentGalleryBinding
import android.util.Pair as UtilPair

class GalleryFragment : Fragment() {

    private var _bind: FragmentGalleryBinding? = null
    private val bind get() = _bind!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _bind = FragmentGalleryBinding.inflate(layoutInflater, container, false)
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mDatas: MutableList<PhotoData> = mutableListOf()
        with(mDatas){
            add(PhotoData("https://madcamp.io/img/intro-together.3087da89.png","몰입캠프"))
            add(PhotoData("https://avatars.githubusercontent.com/u/86835564?s=200&v=4","몰입캠프 GitHub"))
            add(PhotoData("https://madcamp.io/img/intro-other-life-1.b6a0fa59.jpg","몰입캠프2"))
            add(PhotoData("https://madcamp.io/img/intro-immerse-1.a041fbd6.jpg","몰입캠프3"))
            add(PhotoData("https://blog.kakaocdn.net/dn/vzQh8/btqTDcAHG3c/BBq0prrRsJMXyeAYw7kkN0/img.jpg","카이스트 몰입캠프 MADCAMP 참가 후기"))
            add(PhotoData("","img2"))
            add(PhotoData("https://madcamp.io/img/intro-together.3087da89.png","몰입캠프"))
            add(PhotoData("https://avatars.githubusercontent.com/u/86835564?s=200&v=4","몰입캠프 GitHub"))
            add(PhotoData("https://madcamp.io/img/intro-other-life-1.b6a0fa59.jpg","몰입캠프2"))
            add(PhotoData("https://madcamp.io/img/intro-immerse-1.a041fbd6.jpg","몰입캠프3"))
            add(PhotoData("https://blog.kakaocdn.net/dn/vzQh8/btqTDcAHG3c/BBq0prrRsJMXyeAYw7kkN0/img.jpg","카이스트 몰입캠프 MADCAMP 참가 후기"))
            add(PhotoData("","img2"))
            add(PhotoData("https://madcamp.io/img/intro-together.3087da89.png","몰입캠프"))
            add(PhotoData("https://avatars.githubusercontent.com/u/86835564?s=200&v=4","몰입캠프 GitHub"))
            add(PhotoData("https://madcamp.io/img/intro-other-life-1.b6a0fa59.jpg","몰입캠프2"))
            add(PhotoData("https://madcamp.io/img/intro-immerse-1.a041fbd6.jpg","몰입캠프3"))
            add(PhotoData("https://blog.kakaocdn.net/dn/vzQh8/btqTDcAHG3c/BBq0prrRsJMXyeAYw7kkN0/img.jpg","카이스트 몰입캠프 MADCAMP 참가 후기"))
            add(PhotoData("","img2"))
        }
        val adapter = RecyclerViewAdapter()
        adapter.setOnItemClickListener(object: RecyclerViewAdapter.OnItemClickListener {
            override fun onItemClick(v: View, data: PhotoData, pos: Int) {
                val intent: Intent = Intent(activity, GalleryActivity::class.java)
//                intent.putExtra("photoUri", data.photoUri)
//                intent.putExtra("photoDescription", data.photoDescription)
                intent.putExtra("photoData", data)
                intent.putExtra("position", pos)

                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    val imgView: View = v.findViewById<ImageView>(R.id.photoImgView)
                    val options: ActivityOptions = ActivityOptions.makeSceneTransitionAnimation(activity,
                        UtilPair.create(imgView, imgView.transitionName)
                    )
                    startActivity(intent, options.toBundle())
                }
                else {
                    startActivity(intent)
                }
            }
        })
        adapter.photoList = mDatas
        bind.recyclerView.adapter = adapter
        bind.recyclerView.layoutManager = GridLayoutManager(activity, 3, RecyclerView.VERTICAL, false)
    }
}