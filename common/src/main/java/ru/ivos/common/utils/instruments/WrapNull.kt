package ru.ivos.common.utils.instruments

import ru.ivos.common.utils.constants.EMPTY_STRING

inline fun <reified T> wrapNull(target: T?, defaultValue: T? = null): T {
    return when (T::class) {
        String::class -> {
            checkDefaultValue(target, defaultValue) ?: EMPTY_STRING as T
        }
        Long::class -> {
            checkDefaultValue(target, defaultValue) ?: -1L as T
        }
        Double::class -> {
            checkDefaultValue(target, defaultValue) ?: -1.0 as T
        }
        Float::class -> {
            checkDefaultValue(target, defaultValue) ?: -1.0f as T
        }
        Int::class -> {
            checkDefaultValue(target, defaultValue) ?: -1 as T
        }
        Boolean::class -> {
            checkDefaultValue(target, defaultValue) ?: false as T
        }
        else -> {
            throw ClassCastException("wrapNull: not found class in function: $target")
        }
    }
}

inline fun <reified T> checkDefaultValue(target: T?, defaultValue: T?): T? {
    return target ?: defaultValue
}

fun <T> wrapNullList(list: List<T?>?): List<T> {
    return if (list.isNullOrEmpty())
        emptyList()
    else
        list.filterNotNull()
}
