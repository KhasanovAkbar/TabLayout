package pdp.uz.payme

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.google.gson.Gson
import pdp.uz.payme.models.Data
import pdp.uz.payme.utils.MySharedPreference

class MainActivity : AppCompatActivity() {
    lateinit var lst: ArrayList<Data>
    private var gson = Gson()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MySharedPreference.init(this)

        loadData()

    }

    private fun loadData() {


        lst = ArrayList()
        lst.add(
            Data(
                R.drawable.payme,
                "Click va Paymega o'tish xizmati",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pulvinar aliquam at donec facilisis. Lacus, justo, volutpat, diam condimentum ipsum, faucibus rutrum."
            )
        )
        lst.add(
            Data(
                R.drawable.mobiuz,
                "Tariflarni filtrlash",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pulvinar aliquam at donec facilisis. Lacus, justo, volutpat, diam condimentum ipsum, faucibus rutrum."
            )
        )
        lst.add(
            Data(
                R.drawable.group,
                "Yangi imkoniyatlar",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pulvinar aliquam at donec facilisis. Lacus, justo, volutpat, diam condimentum ipsum, faucibus rutrum."
            )
        )
        lst.add(
            Data(
                R.drawable.info,
                "Click va Paymega o'tish xizmati",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pulvinar aliquam at donec facilisis. Lacus, justo, volutpat, diam condimentum ipsum, faucibus rutrum."
            )
        )

        val toJson = gson.toJson(lst)
        MySharedPreference.info = toJson


    }

    override fun onSupportNavigateUp(): Boolean {
        return Navigation.findNavController(this, R.id.my_nav_host_fragment).navigateUp()
    }

}