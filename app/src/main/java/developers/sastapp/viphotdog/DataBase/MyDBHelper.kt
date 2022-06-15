package developers.sastapp.viphotdog.DataBase

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import developers.sastapp.viphotdog.Class.User

class MyDBHelper(context: Context) :
    SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION), MyDBInterface {
    companion object {
        const val DB_NAME = "VIP_HOT_TOG"
        const val DB_VERSION = 1
        const val TABLE_NAME = "SASTAPP"
        const val ID = "id"
        const val NAME = "name"
        const val PRICE = "price"
        const val COUNT = "count"
        const val DATE = "date"
        const val NUMBER = "number"
        const val SELECT = "myselect"
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        val query =
            "create table $TABLE_NAME ($ID integer not null primary key autoincrement unique, $NAME text not null, $PRICE text not null, $COUNT text not null, $DATE text not null, $NUMBER integer not null, $SELECT integer not null)"
        p0?.execSQL(query)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(p0)
    }

    override fun createUser(user: User) {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(NAME, user.name)
        cv.put(PRICE, user.price)
        cv.put(COUNT, user.count)
        cv.put(DATE, user.date)
        cv.put(NUMBER, user.number)
        cv.put(SELECT, user.select)
        db.insert(TABLE_NAME, null, cv)
        db.close()
    }

    @SuppressLint("Recycle")
    override fun readUser(): ArrayList<User> {
        val list = ArrayList<User>()
        val query = "select * from $TABLE_NAME"
        val db = this.readableDatabase
        val cursor = db.rawQuery(query, null)
        if (cursor.moveToFirst()) {
            do {
                val user = User(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getInt(5),
                    cursor.getInt(6)
                )
                list.add(user)
            } while (cursor.moveToNext())
        }
        return list
    }

    override fun updateUser(user: User): Int {
        val cv = ContentValues().apply {
            put(ID, user.id)
            put(NAME, user.name)
            put(PRICE, user.price)
            put(COUNT, user.count)
            put(DATE, user.date)
            put(NUMBER, user.number)
            put(SELECT, user.select)
        }
        return writableDatabase.update(
            TABLE_NAME,
            cv,
            "$ID = ?",
            arrayOf("${user.id}")
        )
    }

    override fun deleteUser(user: User) {
        val db = this.writableDatabase
        db.delete(TABLE_NAME, "$ID = ?", arrayOf("${user.id}"))
        db.close()
    }
}