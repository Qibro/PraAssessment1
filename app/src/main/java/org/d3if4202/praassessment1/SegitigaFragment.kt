package org.d3if4202.praassessment1


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import org.d3if4202.praassessment1.databinding.FragmentSegitigaBinding

class SegitigaFragment : Fragment() {
    lateinit var binding : FragmentSegitigaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_persegi_panjang,container,false)
        return binding.root
    }
}
