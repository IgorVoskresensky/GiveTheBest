package ru.ivos.common.utils.sharedFunctions

object PasswordChecker {

    fun checkAllPasswordConditions(value: String): Boolean {
        return checkPassLowerUpperCase(value)
                &&
                checkNumberCase(value)
                &&
                checkSpecChCase(value)
                &&
                checkPassword(value)
    }

    private fun checkPassLowerUpperCase(value: String): Boolean {
        var isLowerCase = false
        var isUpperCase = false
        for (c in value) {
            if (c.isLowerCase()) isLowerCase = true
            if (c.isUpperCase()) isUpperCase = true
            if (isLowerCase && isUpperCase) break
        }

        return isLowerCase && isUpperCase
    }

    private fun checkNumberCase(value: String): Boolean {
        return value.contains("[0-9]".toRegex())
    }

    private fun checkSpecChCase(value: String): Boolean {
        return value.contains("[!\"#$%&'()*+,-./:;\\\\<=>?@\\[\\]^_`{|}~]".toRegex())
    }

    private fun checkPassword(value: String): Boolean {
        return value.contains("[A-Za-z0-9!\"#$%&'()*+,-./:;\\\\<=>?@\\[\\]^_`{|}~]".toRegex())
    }
}
