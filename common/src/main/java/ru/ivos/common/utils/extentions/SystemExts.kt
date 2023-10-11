package ru.ivos.common.utils.extentions

import ru.ivos.common.BuildConfig

fun ifDebug(block: () -> Unit) {
    if (BuildConfig.DEBUG)
        block.invoke()
}
