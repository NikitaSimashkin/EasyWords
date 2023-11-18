package ru.kram.easywords.base.log

class PrintlnEasyLogger: EasyLogger {
	override fun d(tag: String, message: () -> String) {
		println("D/$tag: ${message()}")
	}

	override fun w(tag: String, message: () -> String) {
		println("W/$tag: ${message()}")
	}

	override fun i(tag: String, message: () -> String) {
		println("I/$tag: ${message()}")
	}

	override fun v(tag: String, message: () -> String) {
		println("V/$tag: ${message()}")
	}

	override fun e(tag: String, message: () -> String) {
		println("E/$tag: ${message()}")
	}

	override fun e(tag: String, throwable: Throwable, message: () -> String) {
		println("E/$tag: ${message()}")
		throwable.printStackTrace()
	}

	override fun wtf(tag: String, message: () -> String) {
		println("WTF/$tag: ${message()}")
	}

	override fun wtf(tag: String, throwable: Throwable, message: () -> String) {
		println("WTF/$tag: ${message()}")
		throwable.printStackTrace()
	}
}