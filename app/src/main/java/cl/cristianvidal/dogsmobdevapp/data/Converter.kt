package cl.cristianvidal.dogsmobdevapp.data

import androidx.room.TypeConverter
import com.google.gson.Gson

/**
 * Created by Cristian Vidal on 2019-12-03.
 */
class Converter {

    @TypeConverter
    fun listToJson(value: List<String>?): String {

        return Gson().toJson(value)
    }

    @TypeConverter
    fun jsonToList(value: String): List<String>? {
        val objects = Gson().fromJson(value, Array<String>::class.java) as Array<String>
        val list = objects.toList()
        return list
    }
}