package vitorota.mvvmposts.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

/**
 *
 * @author Vitor Ota
 * @since 14/01/2019
 */
@Dao
interface PostDao {
    @get:Query("SELECT * FROM Post")
    val all:List<Post>

    @Insert
    fun insertAll(vararg posts:Post)
}