package ru.ivos.common.utils.instruments

import ru.ivos.common.failure.Failure

/*
suspend inline fun <N, L> repositoryOperation(
    noinline networkOperation: suspend () -> N,
    noinline localOperation: suspend (N) -> Unit,
    crossinline resultOperation: suspend () -> L,
): Either<Failure, L> {
    return try {
        localOperation.invoke(networkOperation.invoke())
        Either.Right(resultOperation.invoke())
    } catch (e: Exception) {
        when (e) {
            is ConnectionPoolTimeoutException -> {
                //Timeout ntml auth exp
                Either.Left(ConnectionPoolTimeoutError)
            }
            is SocketTimeoutException -> {
                Either.Left(SocketTimeoutExceptionError)
            }
            is HttpException -> {
                Either.Left(HttpExceptionError)
            }
            else -> {
                Either.Left(ContentErrorFba(e))
            }
        }
    }
}*/
