package nl.jaysh.model.exception

class RequestFailedException(
    override val message: String = "Something went wrong",
    val statusCode: Int,
): Exception(message)

data class RequestFailed(val message: String, val statusCode: Int)
