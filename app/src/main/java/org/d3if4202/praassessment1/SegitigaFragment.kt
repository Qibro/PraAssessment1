package org.d3if4202.praassessment1


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import kotlinx.android.synthetic.main.fragment_persegi_panjang.*
import kotlinx.android.synthetic.main.fragment_segitiga.*
import org.d3if4202.praassessment1.databinding.FragmentSegitigaBinding

class SegitigaFragment : Fragment() {
    var luas = 0.0
    var keliling = 0.0
    lateinit var binding : FragmentSegitigaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_segitiga,container,false)

        if(savedInstanceState != null){
            luas = savedInstanceState.getDouble("luas_key",0.0)
            keliling = savedInstanceState.getDouble("keliling_key",0.0)
        }

        binding.tvSegitigaLuas.setText("$luas")
        binding.tvSegitigaKeliling1.setText("$keliling")

        binding.btnHitungSegitiga.setOnClickListener {
            hitung()
        }

        binding.btnSegitigaShare.setOnClickListener {
            var intent:Intent = Intent(Intent.ACTION_SEND)
            intent.setType("text/html")
            intent.putExtra(Intent.EXTRA_EMAIL,"muhamad.ibrahim21@gmail.com")
            intent.putExtra(Intent.EXTRA_SUBJECT,"Subject")
            startActivity(Intent.createChooser(intent,"Send Email"))
        }

        return binding.root
    }

    fun hitung(){
        var alas = et_segitiga_alas.text.toString()
        var tinggi = et_segitiga_tinggi.text.toString()
        var miring = Math.sqrt(Math.pow(alas.toDouble(),2.0) + Math.pow(tinggi.toDouble(),2.0))

        luas = alas.toDouble() * tinggi.toDouble() / 2
        keliling = alas.toDouble() + tinggi.toDouble() + miring

        tv_segitiga_luas.setText(luas.toString())
        tv_segitiga_keliling1.setText(keliling.toString())

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putDouble("luas_key",luas)
        outState.putDouble("keliling_key",keliling)
    }

}
