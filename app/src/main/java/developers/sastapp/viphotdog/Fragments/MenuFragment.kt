package developers.sastapp.viphotdog.Fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialog
import developers.sastapp.viphotdog.Adapters.MenuAdapter
import developers.sastapp.viphotdog.Class.Menu
import developers.sastapp.viphotdog.Class.User
import developers.sastapp.viphotdog.DataBase.MyDBHelper
import developers.sastapp.viphotdog.Object.MyObject
import developers.sastapp.viphotdog.R
import developers.sastapp.viphotdog.databinding.FragmentMenuBinding
import developers.sastapp.viphotdog.databinding.ItemAddBinding
import java.time.LocalDate
import java.time.LocalTime

@SuppressLint("SetTextI18n")
class MenuFragment : Fragment() {
    private lateinit var binding: FragmentMenuBinding
    private lateinit var list: ArrayList<Menu>
    private lateinit var myDBHelper: MyDBHelper
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMenuBinding.inflate(layoutInflater)
        binding.apply {
            myDBHelper = MyDBHelper(binding.root.context)
            val myList = myDBHelper.readUser()
            start()
            menuRv.adapter = MenuAdapter(list, object : MenuAdapter.OnMenuClickListener {
                override fun onClick(menu: Menu, position: Int) {
                    val bottom = BottomSheetDialog(root.context, R.style.NewDialog)
                    val item = ItemAddBinding.inflate(
                        LayoutInflater.from(root.context),
                        null,
                        false
                    ).apply {
                        addName.text = list[position].name
                        addPrice.text = list[position].price
                        addCount.text = "0 та"
                        var count = 0
                        val mPrice =
                            list[position].price!!.substring(
                                0,
                                list[position].price!!.length - 4
                            ).toInt()
                        addPlus.setOnClickListener {
                            addCount.text = "${++count} та"
                            addPrice.text = "${mPrice * count} сум"
                        }
                        addMinus.setOnClickListener {
                            if (addCount.text != "0 та") {
                                addCount.text = "${--count} та"
                                addPrice.text = "${mPrice * count} сум"
                            }
                            if (addCount.text == "0 та") {
                                addPrice.text = "$mPrice сум"
                            }
                        }
                        addSave.setOnClickListener {
                            if (addCount.text.toString() != "0 та") {
                                val user = User(
                                    addName.text.toString(),
                                    addPrice.text.toString(),
                                    addCount.text.toString(),
                                    local(),
                                    MyObject.pos,
                                    1
                                )
                                myList.add(user)
                                myDBHelper.createUser(user)
                                bottom.cancel()
                            }
                        }
                    }
                    bottom.setCancelable(true)
                    bottom.setContentView(item.root)
                    bottom.show()
                }
            })
            back.setOnClickListener { findNavController().popBackStack() }
            return root
        }
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
        list.add(Menu(R.drawable.gamburger, "Гамбургер", "15000 сум"))
        list.add(Menu(R.drawable.cheeseburger, "Чизбургер", "18000 сум"))
        list.add(Menu(R.drawable.nonkabob, "Нон кабоб", "17000 сум"))
        list.add(Menu(R.drawable.fri, "Фри", "10000 сум"))
        list.add(Menu(R.drawable.banana, "Банан-кок", "11000 сум"))
        list.add(Menu(R.drawable.coffe, "Кофе", "4000 сум"))
    }

    private fun local(): String {
        val month =
            if (LocalDate.now().monthValue.toString().length == 1) "0${LocalDate.now().monthValue}"
            else "${LocalDate.now().monthValue}"
        val day =
            if (LocalDate.now().dayOfMonth.toString().length == 1) "0${LocalDate.now().dayOfMonth}"
            else "${LocalDate.now().dayOfMonth}"
        val hour =
            if (LocalTime.now().hour.toString().length == 1) "0${LocalTime.now().hour}"
            else "${LocalTime.now().hour}"
        val minute =
            if (LocalTime.now().minute.toString().length == 1) "0${LocalTime.now().minute}"
            else "${LocalTime.now().minute}"
        return "$day.$month.${LocalDate.now().year} - $hour:$minute"
    }
}