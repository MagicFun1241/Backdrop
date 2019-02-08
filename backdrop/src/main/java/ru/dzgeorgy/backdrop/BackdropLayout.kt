package ru.dzgeorgy.backdrop

import android.app.Activity
import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class BackdropLayout(context: Context, attrs: AttributeSet) : FrameLayout(context, attrs) {

    private val openIcon: Drawable?
    private val closeIcon: Drawable?
    private val animationDuration: Int
    private var mListener: IBackdropListener? = null

    init {
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.BackdropLayout)
        openIcon = attributes.getDrawable(R.styleable.BackdropLayout_open_icon)
        closeIcon = attributes.getDrawable(R.styleable.BackdropLayout_close_icon)
        if (openIcon == null || closeIcon == null) throw NullAttributesException("Attributes \'open_icon\' and \'close_icon\' must be set before launch!")
        animationDuration = attributes.getInt(R.styleable.BackdropLayout_animation_duration, 500)
        attributes.recycle()
    }

    fun setupWithToolbar(toolbar: Toolbar) {
        mListener = ToolbarBackdropListener(
            this.context,
            getChildAt(0),
            getChildAt(1),
            AccelerateDecelerateInterpolator(),
            openIcon!!,
            closeIcon!!,
            animationDuration,
            toolbar
        )
        toolbar.setNavigationOnClickListener(mListener as ToolbarBackdropListener)
    }

    fun showBackdrop() {
        mListener?.showBackdrop()
    }

    fun hideBackdrop() {
        mListener?.hideBackdrop()
    }

    fun toggleBackdrop() {
        mListener?.toggleBackdrop()
    }

}