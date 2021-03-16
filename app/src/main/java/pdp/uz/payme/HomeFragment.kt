package pdp.uz.payme

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import pdp.uz.payme.adapters.IndicatorAdapter
import pdp.uz.payme.models.Data
import pdp.uz.payme.utils.MySharedPreference
import java.lang.reflect.Type

class HomeFragment : Fragment() {

    lateinit var root: View
    private var gson = Gson()
    lateinit var indicatorAdapter: IndicatorAdapter
    lateinit var data: ArrayList<Data>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_home, container, false)
        MySharedPreference.init(container!!.context)
        val info = MySharedPreference.info
        val type: Type = object : TypeToken<ArrayList<Data>>() {}.type
        data = gson.fromJson(info, type)

        root.cancel_btn.setOnClickListener {
            root.findNavController().navigate(R.id.secondFragment)
        }

        root.next_btn.setOnClickListener {
            if (view_pager.currentItem < 3) {
                root.view_pager.setCurrentItem(getItem(+1), true)
            } else {
                root.findNavController().navigate(R.id.secondFragment)
            }
        }
        return root
    }

    private fun getItem(i: Int): Int {
        return view_pager.currentItem + 1
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        indicatorAdapter = IndicatorAdapter(data, childFragmentManager)
        view_pager.adapter = indicatorAdapter
        tab_indicator.setupWithViewPager(view_pager)
        settingStatusBarTransparent()

    }

    private fun settingStatusBarTransparent() {
        val w: Window = requireActivity().window // in Activity's onCreate() for instance
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            w.navigationBarColor = Color.BLACK
            w.setFlags(
                WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS,
                WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS
            )
            w.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
            w.statusBarColor = Color.TRANSPARENT
        }
    }

}