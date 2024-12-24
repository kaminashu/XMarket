package www.uzmd.xmarket.database

import androidx.room.Dao
import androidx.room.Query

@Dao
interface ServiceDao {
    @Query("INSERT INTO user (login,parol) values (:login,:parol)")
    fun addDb(login:String,parol:Int)

    @Query("SELECT *FROM user where id=:myid")
    fun getUser(myid:Int):Person?

}