package www.uzmd.xmarket.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("user")
class Person(
    @PrimaryKey(autoGenerate = true)
    var id: Int=0,
    var login: String?,
    var parol: Int?
)