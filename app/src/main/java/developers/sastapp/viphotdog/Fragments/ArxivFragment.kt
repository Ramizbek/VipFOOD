package developers.sastapp.viphotdog.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import developers.sastapp.viphotdog.Adapters.ArxivAdapter
import developers.sastapp.viphotdog.Class.User
import developers.sastapp.viphotdog.DataBase.MyDBHelper
import developers.sastapp.viphotdog.Object.MyObject
import developers.sastapp.viphotdog.databinding.FragmentArxivBinding

class ArxivFragment : Fragment() {
    private lateinit var binding: FragmentArxivBinding
    private lateinit var myDBHelper: MyDBHelper
    private lateinit var list: ArrayList<User>
    private lateinit var posList: ArrayList<User>
    private lateinit var arxivAdapter: ArxivAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentArxivBinding.inflate(layoutInflater)
        binding.apply {
            myDBHelper = MyDBHelper(root.context)
            list = myDBHelper.readUser()
            posList = ArrayList()
            for (i in list) {
                if (i.number == MyObject.pos && i.select == 0) posList.add(i)
            }
            arxivAdapter = ArxivAdapter(posList)
            arxivRv.adapter = arxivAdapter
            back.setOnClickListener { findNavController().popBackStack() }
            var price = 0
            for (i in posList) {
                price += i.price!!.substring(0, i.price!!.length - 4).toInt()
            }
            total.text = "$price сум"
            return root
        }
    }
}