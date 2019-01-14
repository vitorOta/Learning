package vitorota.mvvmposts.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import vitorota.mvvmposts.model.Post
import vitorota.mvvmposts.model.PostDao


/**
 *
 * @author Vitor Ota
 * @since 14/01/2019
 */
@Database(entities = arrayOf(Post::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun postDao():PostDao
}