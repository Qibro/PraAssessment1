package org.d3if4202.praassessment1


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import org.d3if4202.praassessment1.databinding.FragmentPersegiPanjangBinding

class PersegiPanjangFragment : Fragment() {
    lateinit var binding : FragmentPersegiPanjangBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_persegi_panjang,container,false)
        return binding.root
    }
}
