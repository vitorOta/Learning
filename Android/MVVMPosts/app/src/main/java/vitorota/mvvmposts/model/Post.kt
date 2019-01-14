package vitorota.mvvmposts.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 *
 * @author Vitor Ota
 * @since 11/01/2019
 */
@Entity
data class Post(
    val userId: Int,
    @field:PrimaryKey
    val id: Int,
    val title: String,
    val body: String
)