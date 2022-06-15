package developers.sastapp.viphotdog.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import developers.sastapp.viphotdog.Adapters.SelectableAdapter
import developers.sastapp.viphotdog.Class.User
import developers.sastapp.viphotdog.DataBase.MyDBHelper
import developers.sastapp.viphotdog.Object.MyObject
import developers.sastapp.viphotdog.databinding.FragmentSelectableBinding

class SelectableFragment : Fragment() {
    private lateinit var binding: FragmentSelectableBinding
    private lateinit var myDBHelper: MyDBHelper
    private lateinit var list: ArrayList<User>
    private lateinit var posList: ArrayList<User>
    private lateinit var selectableAdapter: SelectableAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSelectableBinding.inflate(layoutInflater)
        binding.apply {
            myDBHelper = MyDBHelper(root.context)
            list = myDBHelper.readUser()
            posList = ArrayList()
            for (i in list) {
                if (i.number == MyObject.pos && i.select == 1) posList.add(i)
            }
            selectableAdapter = SelectableAdapter(posList)
            selectableRv.adapter = selectableAdapter
            if (posList.isNotEmpty()) {
                delete.visibility = View.VISIBLE
                delete.setOnClickListener {
                    for (i in posList) {
                        val index = posList.indexOf(i)
                        val user = User(
                            i.id,
                            i.name,
                            i.price,
                            i.count,
                            i.date,
                            i.number,
                            0
                        )
                        myDBHelper.updateUser(user)
                        list[index] = user
                        posList.remove(user)
                        selectableRv.visibility = View.INVISIBLE
                    }
                    it.visibility = View.INVISIBLE
                }
            } else delete.visibility = View.INVISIBLE
            return root
        }
    }
}