package pdp.uz.payme.utils

import android.content.Context
import android.content.SharedPreferences

object MySharedPreference {

    private const val NAME = "PAYME"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var sharedPreferences: SharedPreferences

    fun init(context: Context) {
        sharedPreferences = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var info: String?
        get() = sharedPreferences.getString("info", "")
        set(value) = sharedPreferences.edit {
            if (value != null) {
                it.putString("info", value)
            }
        }
}