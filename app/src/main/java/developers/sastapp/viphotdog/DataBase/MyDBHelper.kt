package developers.sastapp.viphotdog.DataBase

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import developers.sastapp.viphotdog.Class.User

class MyDBHelper(context: Context) :
    SQLiteOpenHelper(context, DB_NAME, null, VERSION), MyDBInterface {
    companion object {
        const val DB_NAME = "Vip"
        const val TABLE_NAME = "HotDog"
        const val VERSION = 1
        const val ID = "id"
        const val ID_TABLE = "tableId"
        const val NAME = "name"
        const val PRICE = "price"
        const val COUNT = "count"
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        val query =
            "CREATE TABLE $TABLE_NAME ($ID integer not null primary key autoincrement unique, $ID_TABLE integer not null, $NAME text not null, $PRICE text not null, $COUNT text not null)"
        p0?.execSQL(query)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(p0)
    }

    override fun createUser(user: User) {
        val dataBase = this.writableDatabase
        val contentView = ContentValues().apply {
            put(ID_TABLE, user.tableId)
            put(NAME, user.name)
            put(PRICE, user.price)
            put(COUNT, user.count)
        }
        dataBase.insert(TABLE_NAME, null, contentView)
        dataBase.close()
    }

    override fun readUser(): ArrayList<User> {
        val list = ArrayList<User>()
        val query = "SELECT * FROM $TABLE_NAME"
        val database = this.readableDatabase
        val cursor = database.rawQuery(query, null)
        if (cursor.moveToFirst()) {
            do {
                val user = User(
                    cursor.getInt(0),
                    cursor.getInt(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4)
                )
                list.add(user)
            } while (cursor.moveToNext())
        }
        return list
    }

    override fun deleteUser(user: User) {
        val database = this.writableDatabase
        database.delete(TABLE_NAME, "$ID = ?", arrayOf("${user.id}"))
        database.close()
    }
}