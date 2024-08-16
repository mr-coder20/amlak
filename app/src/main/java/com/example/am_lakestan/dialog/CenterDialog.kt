import android.app.Application.MODE_PRIVATE
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.TextView
import com.example.am_lakestan.R
import com.example.am_lakestan.common.language.LocaleHelper


class CenterDialog(context: Context) : Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_layout)


        val english_lang = findViewById<TextView>(R.id.english_lang)
        val persian_lang = findViewById<TextView>(R.id.persian_lang)
        val arabic_lang = findViewById<TextView>(R.id.arabic_lang)
        val button = findViewById<Button>(R.id.dialog_button)


        val sharedPref=context.getSharedPreferences(
            "language",
            MODE_PRIVATE
        )


        button.setOnClickListener {
            dismiss()
        }
        english_lang.setOnClickListener {
            sharedPref.edit().apply {
                val language = "en"
                putString("language", language)
            }.apply()
            LocaleHelper.activityReStarter(context)
            dismiss()
        }
        persian_lang.setOnClickListener {
            sharedPref.edit().apply {
                val language = "fa"
                putString("language", language)
            }.apply()
            LocaleHelper.activityReStarter(context)
            dismiss()

        }
        arabic_lang.setOnClickListener {
            sharedPref.edit().apply {
                val language = "ar"
                putString("language", language)
            }.apply()
            LocaleHelper.activityReStarter(context)
            dismiss()
        }







        window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        window?.setBackgroundDrawableResource(R.drawable.rounded_corners)


        window?.setGravity(Gravity.CENTER)
    }


}
// fun changeLanguage(languageCode: String,context: Context) {
//    val locale = Locale(languageCode)
//    Locale.setDefault(locale)
//    val config = Configuration()
//    config.locale = locale
//     context.resources.updateConfiguration(config, context.resources.displayMetrics)
//    // Restart the activity to apply the language change
//    val intent = Intent(context, IntroActivity::class.java)
//    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
//    context.startActivity(intent)
//
//}