package id.kanesa.kanesaservice.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class BottomNavPagerAdapter(
    private val fragmentList: List<Fragment>,
    fm: FragmentManager?
) :
    FragmentStatePagerAdapter(fm!!) {
    override fun getItem(position: Int): Fragment {
        return if (position >= 0 && position < fragmentList.size) {
            fragmentList[position]
        } else Fragment()
    }

    override fun getCount(): Int {
        return fragmentList.size
    }

}