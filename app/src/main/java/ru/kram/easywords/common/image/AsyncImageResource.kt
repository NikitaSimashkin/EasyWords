package ru.kram.easywords.common.image

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.core.content.res.ResourcesCompat
import coil.ImageLoader
import coil.request.ImageRequest
import util.ImageUtils.toBitmap

sealed class AsyncImageResource {

	data class BitmapResource(
		override val contentDescription: String,
		val bitmap: Bitmap
	) : AsyncImageResource() {
		override suspend fun loadBitmap(context: Context): Bitmap {
			return bitmap
		}

		override suspend fun loadDrawable(context: Context): Drawable {
			return BitmapDrawable(context.resources, bitmap)
		}
	}

	data class DrawableResource(
		override val contentDescription: String,
		val drawable: Drawable
	) : AsyncImageResource() {
		override suspend fun loadDrawable(context: Context): Drawable {
			return drawable
		}

		override suspend fun loadBitmap(context: Context): Bitmap {
			return drawable.toBitmap()
		}
	}


	data class ResourceId(
		override val contentDescription: String,
		val resourceId: Int
	) : AsyncImageResource() {
		override suspend fun loadBitmap(context: Context): Bitmap? {
			val drawable = loadDrawable(context)
			return drawable?.toBitmap()
		}

		override suspend fun loadDrawable(context: Context): Drawable? {
			return ResourcesCompat.getDrawable(context.resources, resourceId, context.theme)
		}
	}

	data class Url(
		override val contentDescription: String,
		val path: String
	) : AsyncImageResource() {
		override suspend fun loadBitmap(context: Context): Bitmap? {
			val request = ImageRequest.Builder(context).data(path).build()
			return ImageLoader(context).execute(request).drawable?.toBitmap()
		}

		override suspend fun loadDrawable(context: Context): Drawable? {
			val request = ImageRequest.Builder(context).data(path).build()
			return ImageLoader(context).execute(request).drawable
		}
	}


	data class File(
		override val contentDescription: String,
		val path: String
	) : AsyncImageResource() {
		override suspend fun loadBitmap(context: Context): Bitmap? {
			val request = ImageRequest.Builder(context).data(java.io.File(path)).build()
			return ImageLoader(context).execute(request).drawable?.toBitmap()
		}

		override suspend fun loadDrawable(context: Context): Drawable? {
			val data = java.io.File(path)
			return ImageLoader(context).execute(ImageRequest.Builder(context).data(data).build()).drawable
		}
	}

	abstract val contentDescription: String

	@Throws(Exception::class)
	abstract suspend fun loadDrawable(context: Context): Drawable?

	@Throws(Exception::class)
	abstract suspend fun loadBitmap(context: Context): Bitmap?
}