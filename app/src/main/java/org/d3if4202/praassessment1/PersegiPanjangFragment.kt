package org.d3if4202.praassessment1


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import kotlinx.android.synthetic.main.fragment_persegi_panjang.*
import org.d3if4202.praassessment1.databinding.FragmentPersegiPanjangBinding

class PersegiPanjangFragment : Fragment() {
    lateinit var binding : FragmentPersegiPanjangBinding
    var panjang = ""
    var lebar = ""
    var luas = 0
    var keliling = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_persegi_panjang,container,false)
        if(savedInstanceState != null){
            luas = savedInstanceState.getInt("luas_key",0)
            keliling = savedInstanceState.getInt("keliling_key",0)
        }

        binding.tvPpLuas.setText("$luas")
        binding.tvPpKeliling.setText("$keliling")

        binding.btnHitungPp.setOnClickListener {
            hitung()
        }

        binding.btnPpShare.setOnClickListener {
            var intent: Intent = Intent(Intent.ACTION_SEND)
            intent.setType("text/html")
            intent.putExtra(Intent.EXTRA_EMAIL,"muhamad.ibrahim21@gmail.com")
            intent.putExtra(Intent.EXTRA_SUBJECT,"Subject")
            startActivity(Intent.createChooser(intent,"Send Email"))
        }

        return binding.root
    }

    fun hitung(){
         lebar = et_pp_lebar.text.toString()
         panjang = et_pp_panjang.text.toString()

         luas = panjang.toInt() * lebar.toInt()
         keliling = 2 * (panjang.toInt() + lebar.toInt())

        tv_pp_luas.setText(luas.toString())
        tv_pp_keliling.setText(keliling.toString())
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("luas_key",luas)
        outState.putInt("keliling_key",keliling)
    }
}
