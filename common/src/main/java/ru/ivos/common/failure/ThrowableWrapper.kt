package ru.ivos.common.failure

import ru.ivos.common.failure.Failure

data class ThrowableWrapper(val throwable: Throwable = Throwable()) : Failure
