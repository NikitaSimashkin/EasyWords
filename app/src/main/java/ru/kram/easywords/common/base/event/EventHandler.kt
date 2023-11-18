package ru.kram.easywords.common.base.event

import ru.kram.easywords.common.base.event.model.Event

interface EventHandler<T: Event> {
	fun handleEvent(event: T)
}
