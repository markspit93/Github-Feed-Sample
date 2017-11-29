package com.github.feed.sample.ui.main

import android.os.Bundle
import android.support.annotation.ColorRes
import android.support.annotation.IdRes
import android.support.v4.view.GravityCompat
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.widget.CheckBox
import com.github.feed.sample.R
import com.github.feed.sample.data.*
import com.github.feed.sample.data.model.Event
import com.github.feed.sample.ext.*
import com.github.feed.sample.ui.common.mvp.MvpActivity
import com.github.feed.sample.ui.common.mvp.NoViewModel
import com.github.feed.sample.ui.details.DetailsActivity
import com.github.feed.sample.ui.eventlist.EventListFragment
import com.google.android.gms.oss.licenses.OssLicensesMenuActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*
import org.jetbrains.anko.intentFor

class MainActivity : MvpActivity<MainContract.View, MainPresenter, NoViewModel>(), MainContract.View {

    companion object {
        private val FRAGMENT_TAG_EVENTS = "fragment_tag_events"
    }

    private var eventsFragment: EventListFragment? = null
    private var checkBoxList = mutableListOf<CheckBox>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        eventsFragment = findFragment(FRAGMENT_TAG_EVENTS) as EventListFragment?

        if (eventsFragment == null){
            eventsFragment = EventListFragment().apply {
                addFragment(this, R.id.container, FRAGMENT_TAG_EVENTS)
            }
        }

        requireNotNull(eventsFragment).eventClick = onEventClicked

        setupFilters()
    }

    override fun onStart() {
        super.onStart()
        presenter.loadFilterSelections()
        setTaskColor(getColorCompat(R.color.colorPrimary))
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        menu.findItem(R.id.menu_item_filter).isVisible = hasInternetConnection()

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_item_filter -> drawerLayout.openDrawer(Gravity.END)
            R.id.menu_item_licenses -> startActivity(intentFor<OssLicensesMenuActivity>())
        }

        return true
    }

    private val onEventClicked: (Event) -> Unit = { event ->
        startActivityTransition(DetailsActivity.createIntent(this, event))
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.END)) {
            drawerLayout.closeDrawer(Gravity.END)
        } else {
            super.onBackPressed()
        }
    }

    override fun selectFilter(tag: String, selected: Boolean) {
        checkBoxList.find { it.tag as String == tag }?.isChecked = selected
    }

    private fun setupFilters() {
        setupCheckBox(R.id.action_filter_create, R.color.orange_A400, EVENT_CREATE)
        setupCheckBox(R.id.action_filter_delete, R.color.purple_A200, EVENT_DELETE)
        setupCheckBox(R.id.action_filter_fork, R.color.green_A400, EVENT_FORK)
        setupCheckBox(R.id.action_filter_pull_request, R.color.deep_purple_A200, EVENT_PULL_REQUEST)
        setupCheckBox(R.id.action_filter_push, R.color.red_A200, EVENT_PUSH)
        setupCheckBox(R.id.action_filter_watch, R.color.indigo_A400, EVENT_WATCH)

        navigationView.setNavigationItemSelectedListener { item ->
            (item.actionView as CheckBox).apply { post { isChecked = !isChecked } }
            true
        }
    }

    private fun setupCheckBox(@IdRes checkboxId: Int, @ColorRes colorId: Int, eventType: String) {
        navigationView.findCheckbox(checkboxId).apply {
            checkBoxList.add(this)

            tag = eventType
            isChecked = true
            setButtonTintColor(colorId)
            setOnCheckedChangeListener { _, isChecked ->
                presenter.saveFilterSelection(tag as String, isChecked)

                if (isChecked) {
                    requireNotNull(eventsFragment).unfilterEventType(eventType)
                } else {
                    requireNotNull(eventsFragment).filterEventType(eventType)
                }
            }
        }
    }
}
