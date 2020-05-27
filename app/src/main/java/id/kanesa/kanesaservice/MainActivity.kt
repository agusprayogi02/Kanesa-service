package id.kanesa.kanesaservice

import android.content.Context
import android.graphics.Typeface
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import id.kanesa.kanesaservice.adapter.BottomNavPagerAdapter
import id.kanesa.kanesaservice.ui.home.HomeFragment
import id.kanesa.kanesaservice.ui.pesanan.PesananFragment
import id.kanesa.kanesaservice.ui.profile.ProfileFragment
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bnlv = bottom_navigation_bar
        bnlv.setTypeface(Typeface.createFromAsset(assets, "fonts/SF-Medium.otf"))
        val fragList = ArrayList<Fragment>()
        fragList.add(HomeFragment())
        fragList.add(PesananFragment())
        fragList.add(ProfileFragment())
        val pagerAdapter = BottomNavPagerAdapter(fragList, supportFragmentManager)
        val viewPager = view_pager
        viewPager.offscreenPageLimit = 3
        viewPager.adapter = pagerAdapter

        bnlv.setNavigationChangeListener { _, position ->
            viewPager.setCurrentItem(
                position,
                true
            )
        }
    }
}
