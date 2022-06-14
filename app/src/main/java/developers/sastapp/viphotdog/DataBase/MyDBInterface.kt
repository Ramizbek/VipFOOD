package developers.sastapp.viphotdog.DataBase

import developers.sastapp.viphotdog.Class.User

interface MyDBInterface {
    fun createUser(user: User)
    fun readUser(): ArrayList<User>
    fun deleteUser(user: User)
}