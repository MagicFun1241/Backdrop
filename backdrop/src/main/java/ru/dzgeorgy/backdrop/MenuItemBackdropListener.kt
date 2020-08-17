package ru.dzgeorgy.backdrop

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.drawable.Drawable
import android.view.MenuItem
import android.view.View
import android.view.animation.Interpolator

class MenuItemBackdropListener @JvmOverloads internal constructor(
    private val context: Context,
    private val backLayer: View,
    private val frontLayer: View,
    private val interpolator: Interpolator? = null,
    private val openIcon: Drawable,
    private val closeIcon: Drawable,
    private val animationDuration: Int,
    private val menuItem: MenuItem
) : MenuItem.OnMenuItemClickListener, BackdropListener {

    private val animatorSet = AnimatorSet()
    private var backdropShown = false

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        toggleBackdrop()
        return true
    }

    override fun showBackdrop() {
        backdropShown = false
        toggleBackdrop()
    }

    override fun hideBackdrop() {
        backdropShown = true
        toggleBackdrop()
    }

    override fun toggleBackdrop() {
        backdropShown = !backdropShown

        animatorSet.removeAllListeners()
        animatorSet.end()
        animatorSet.cancel()

        updateIcon()

        val animator = ObjectAnimator.ofFloat(
            frontLayer,
            "translationY",
            (if (backdropShown) backLayer.height else 0).toFloat()
        )
        animator.duration = animationDuration.toLong()

        if (interpolator != null) animator.interpolator = interpolator
        animatorSet.play(animator)
        animator.start()
    }

    private fun updateIcon() {
        if (backdropShown) {
            menuItem.icon = closeIcon
        } else {
            menuItem.icon = openIcon
        }
    }


}