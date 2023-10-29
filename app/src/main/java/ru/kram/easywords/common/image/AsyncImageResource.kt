package ru.kram.easywords.common.image

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import coil.ImageLoader
import coil.request.ImageRequest
import util.ImageUtils.toBitmap

sealed class AsyncImageResource {

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