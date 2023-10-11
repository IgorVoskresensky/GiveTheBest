package ru.ivos.common.utils.extentions

import ru.ivos.common.utils.constants.PHONE_MASK
import ru.ivos.common.utils.constants.PHONE_MASK_WITH_SEVEN

fun String.replaceFirstCharPhoneWithMask(): Pair<String, String> {
    return if (isNotEmpty() && this.first() in listOf('+', '7', '8'))
        Pair(first = this.replaceFirstChar { '7' }, second = PHONE_MASK)
    else
        Pair(first = this, second = PHONE_MASK_WITH_SEVEN)
}
