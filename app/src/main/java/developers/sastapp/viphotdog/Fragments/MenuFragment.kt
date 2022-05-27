package developers.sastapp.viphotdog.Fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialog
import developers.sastapp.viphotdog.Adapters.MenuAdapter
import developers.sastapp.viphotdog.Adapters.OnMenuClickListener
import developers.sastapp.viphotdog.Models.Menu
import developers.sastapp.viphotdog.Models.Selectable
import developers.sastapp.viphotdog.MyData
import developers.sastapp.viphotdog.R
import developers.sastapp.viphotdog.databinding.FragmentMenuBinding
import developers.sastapp.viphotdog.databinding.ItemAddBinding

class MenuFragment : Fragment() {
    private lateinit var binding: FragmentMenuBinding
    private lateinit var list: ArrayList<Menu>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMenuBinding.inflate(layoutInflater)

        // Position for table of main fragment
        val tablePosition = arguments?.getInt("tablePos")
        start()
        binding.apply {
            menuRv.adapter = MenuAdapter(list, object : OnMenuClickListener {
                @SuppressLint("SetTextI18n")
                override fun onClick(menu: Menu, position: Int) {
                    val bottom = BottomSheetDialog(binding.root.context, R.style.NewDialog)
                    val item = ItemAddBinding.inflate(
                        LayoutInflater.from(binding.root.context),
                        null,
                        false
                    )
                    bottom.setContentView(item.root)
                    bottom.show()
                    item.apply {
                        var count = 0
                        val mPrice =
                            list[position].price.substring(0, list[position].price.length - 4)
                                .toInt()
                        addPlus.setOnClickListener {
                            addCount.text = "${++count}"
                            addPrice.text = "${mPrice * count} сум"
                        }
                        addMinus.setOnClickListener {
                            if (addCount.text != "0") {
                                addCount.text = "${--count}"
                                addPrice.text = "${mPrice * count} сум"
                            }
                            if (addCount.text == "0") {
                                addPrice.text = "$mPrice сум"
                            }
                        }
                        addName.text = list[position].name
                        addPrice.text = list[position].price
                        addSave.setOnClickListener {
                            MyData.myList.add(
                                Selectable(
                                    addName.text.toString(),
                                    addPrice.text.toString(),
                                    addCount.text.toString()
                                )
                            )
//                            Bundle().putString("name", addName.text.toString())
//                            Bundle().putString("price", addPrice.text.toString())
//                            Bundle().putString("count", addCount.text.toString())
                            bottom.cancel()
                        }
                    }
                }
            })
        }
        return binding.root
    }

    private fun start() {
        list = ArrayList()
        list.add(Menu(R.drawable.miks, "Микс Мал", "17000 сум"))
        list.add(Menu(R.drawable.miks, "Микс Бол", "25000 сум"))
        list.add(Menu(R.drawable.kur, "Кур Мал", "11000 сум"))
        list.add(Menu(R.drawable.kur, "Кур Бол", "17000 сум"))
        list.add(Menu(R.drawable.kotlet, "Котлет Мал", "12000 сум"))
        list.add(Menu(R.drawable.kotlet, "Котлет Бол", "19000 сум"))
        list.add(Menu(R.drawable.qazi, "Казы Мал", "11000 сум"))
        list.add(Menu(R.drawable.qazi, "Казы Бол", "17000 сум"))
        list.add(Menu(R.drawable.fri, "Фри", "10000 сум"))
        list.add(Menu(R.drawable.coffe, "Кофе", "4000 сум"))
        list.add(Menu(R.drawable.moxito, "Мохито", "10000 сум"))
        list.add(Menu(R.drawable.banana, "Банан-кок", "11000 сум"))
        list.add(Menu(R.drawable.cheeseburger, "Чизбургер", "18000 сум"))
        list.add(Menu(R.drawable.gamburger, "Гамбургер", "15000 сум"))
    }
}