package vitorota.mvvmposts.model

/**
 *
 * @author Vitor Ota
 * @since 11/01/2019
 */
data class Post(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)