package com.github.feed.sample.ui.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import com.github.feed.sample.R
import com.github.feed.sample.data.model.Event
import com.github.feed.sample.ext.gone
import com.github.feed.sample.ext.loadCircleImage
import com.github.feed.sample.ext.setTaskColor
import com.github.feed.sample.ui.common.BaseActivity
import com.github.feed.sample.util.ColorUtils
import com.github.feed.sample.util.DateUtils
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.card_info.*
import kotlinx.android.synthetic.main.card_org.*
import kotlinx.android.synthetic.main.card_repo.*
import kotlinx.android.synthetic.main.toolbar.*

class DetailsActivity : BaseActivity() {

    companion object {
        private const val EXTRA_EVENT = "extra_event"

        fun createIntent(ctx: Context, event: Event) =
            Intent(ctx, DetailsActivity::class.java).apply {
                putExtra(EXTRA_EVENT, event)
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowTitleEnabled(false)

        val event: Event = intent.extras.getParcelable(EXTRA_EVENT)
        val color = ColorUtils.getColorForType(this, event.type)

        appBarLayout.setBackgroundColor(color)
        toolbar.setBackgroundColor(color)
        setTaskColor(color)

        showInfo(event, color)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finishAfterTransition()
        }

        return true
    }

    override fun onBackPressed() {
        finishAfterTransition()
    }

    private fun showInfo(event: Event, color: Int) {
        imgAvatar.loadCircleImage(event.actor.avatar)
        txtName.text = event.actor.username

        txtInfoTitle.setTextColor(color)
        txtInfoType.text = getString(R.string.details_info_type, event.type.removeSuffix("Event"))
        txtInfoPublic.text = getString(R.string.details_info_public, getString(if (event.public) R.string.yes else R.string.no))
        txtInfoDate.text = getString(R.string.details_info_date, DateUtils.formatDate(this, event.creationDate))

        txtRepoTitle.setTextColor(color)
        txtRepoID.text = getString(R.string.details_repo_id, event.repository.id.toString())
        txtRepoName.text = getString(R.string.details_repo_name, event.repository.name)
        txtRepoUrl.text = getString(R.string.details_repo_url, event.repository.url)

        if (event.organization != null) {
            txtOrgTitle.setTextColor(color)
            txtOrgID.text = getString(R.string.details_org_id, event.organization.id.toString())
            txtOrgUrl.text = getString(R.string.details_org_url, event.organization.url)
            imgOrgAvatar.loadCircleImage(event.actor.avatar)
        } else {
            cardOrg.gone()
        }
    }
}
