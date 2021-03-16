package pdp.uz.payme.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import pdp.uz.payme.ImageFragment
import pdp.uz.payme.models.Data

class IndicatorAdapter(var list: ArrayList<Data>, fragmentManager: FragmentManager) :
    FragmentPagerAdapter(
        fragmentManager,
        BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
    ) {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Fragment {
        return ImageFragment.newInstance(list[position])
    }
}