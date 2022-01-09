package ru.fefu.hw

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class CollectionAdapterFragment : Fragment(), Parent {
    private lateinit var activityCollectionAdapter: ActivityCollectionAdapter
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        activityCollectionAdapter = ActivityCollectionAdapter(this)
        viewPager = view.findViewById(R.id.activity_pager)
        viewPager.adapter = activityCollectionAdapter
        tabLayout = view.findViewById(R.id.activity_tab_layout)
        TabLayoutMediator(
            tabLayout,
            viewPager
        ) { tab, position ->
            tab.text = when (position) {
                0 -> "Моя"
                else -> "Пользователей"
            }
        }
            .attach()

    }

    companion object {
        @JvmStatic
        fun newInstance() = CollectionAdapterFragment()
    }

    override fun getActivitiesFragmentManager(): FragmentManager =
        (parentFragment as Parent)
            .getActivitiesFragmentManager()
}

class ActivityCollectionAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> MyActivity()
            else -> UsersActivity()
        }
    }
}
