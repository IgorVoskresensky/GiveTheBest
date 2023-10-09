package ru.ivos.common.failure

import ru.ivos.common.R

interface Failure {

    fun getFailureMessage(): Int = R.string.main_error

}
