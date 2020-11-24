package com.cerlaw.learningapplication.ViewMove

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.Scroller

class CustomView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private var lastX = 0
    private var lastY = 0
    private val scroller = Scroller(context)

    override fun onTouchEvent(event: MotionEvent): Boolean {
        //记录下手指点击的位置
        val x = event.x.toInt()
        val y = event.y.toInt()

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                lastX = x
                lastY = y
            }
            MotionEvent.ACTION_MOVE -> {
                val offsetX = x - lastX
                val offsetY = y - lastY
                //1、通过layout方法改变View的位置
//                layout(left + offsetX, top + offsetY, right + offsetX, bottom + offsetY)
                //2、通过offsetLeftAndRight和offsetTopAndBottom改变offset
//                offsetLeftAndRight(offsetX)
//                offsetTopAndBottom(offsetY)
                //3、改变LayoutParams
//                val params = layoutParams as ConstraintLayout.LayoutParams
//                params.leftMargin = left + offsetX
//                params.topMargin = top + offsetY
//                layoutParams = params
                //4、scrollTo、scrollBy
//                (parent as View).scrollBy(-offsetX, -offsetY)
                //5、scroller
                smoothScrollTo(-offsetX, -offsetY)
            }
        }
        return true
    }

    override fun computeScroll() {
        super.computeScroll()
        if (scroller.computeScrollOffset()) {
            (parent as View).scrollTo(scroller.currX, scroller.currY)
            invalidate()
        }
    }

    fun smoothScrollTo(destX: Int, destY: Int) {
        // TODO: 2020/11/23 从原点开始的？
        val deltaX = destX - left
        val deltaY = destY - top
        scroller.startScroll(left, top, deltaX, deltaY, 2000)
        invalidate()
    }
}