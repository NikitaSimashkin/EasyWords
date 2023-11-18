package ru.kram.easywords.base.log

class AndroidEasyLogger: EasyLogger {

	override fun d(tag: String, message: () -> String) {
		android.util.Log.d(tag, message())
	}

	override fun w(tag: String, message: () -> String) {
		android.util.Log.w(tag, message())
	}

	override fun i(tag: String, message: () -> String) {
		android.util.Log.i(tag, message())
	}

	override fun v(tag: String, message: () -> String) {
		android.util.Log.v(tag, message())
	}

	override fun e(tag: String, message: () -> String) {
		android.util.Log.e(tag, message())
	}

	override fun e(tag: String, throwable: Throwable, message: () -> String) {
		android.util.Log.e(tag, message(), throwable)
	}

	override fun wtf(tag: String, message: () -> String) {
		android.util.Log.wtf(tag, message())
	}

	override fun wtf(tag: String, throwable: Throwable, message: () -> String) {
		android.util.Log.wtf(tag, message(), throwable)
	}
}
