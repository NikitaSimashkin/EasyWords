package ru.kram.easywords.common.image

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.core.content.res.ResourcesCompat
import util.ImageUtils.toBitmap

sealed class ImageResource {

    data class BitmapResource(
		override val contentDescription: String,
		val bitmap: Bitmap
	) : ImageResource() {
        override fun getBitmap(context: Context): Bitmap {
            return bitmap
        }

        override fun getDrawable(context: Context): Drawable {
            return BitmapDrawable(context.resources, bitmap)
        }
    }

    data class DrawableResource(
		override val contentDescription: String,
		val drawable: Drawable
	) : ImageResource() {
        override fun getDrawable(context: Context): Drawable {
            return drawable
        }

        override fun getBitmap(context: Context): Bitmap {
            return drawable.toBitmap()
        }
    }


    data class ResourceId(
		override val contentDescription: String,
		val resourceId: Int
	) : ImageResource() {
        override fun getBitmap(context: Context): Bitmap {
            val drawable = getDrawable(context)
            return drawable.toBitmap()
        }

        override fun getDrawable(context: Context): Drawable {
            return requireNotNull(ResourcesCompat.getDrawable(context.resources, resourceId, context.theme))
        }
    }

	abstract val contentDescription: String

    @Throws(Exception::class)
    abstract fun getDrawable(context: Context): Drawable

    @Throws(Exception::class)
    abstract fun getBitmap(context: Context): Bitmap
}