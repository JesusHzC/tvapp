package com.github.jesushzc.tvapp.domain.use_case

import android.text.format.DateFormat
import com.github.jesushzc.tvapp.utils.TypeDateFormat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DateFormatterUseCase {

    operator fun invoke(type: TypeDateFormat): String {
        val date = System.currentTimeMillis()
        return when (type) {
            TypeDateFormat.DATE_ISO -> {
                DateFormat.format("yyyy-MM-dd", date).toString()
            }
            TypeDateFormat.DATE_FULL_STRING -> {
                val locale = Locale("es", "MX")
                val sdf = SimpleDateFormat("EEEE d 'de' MMMM yyyy", locale)
                return sdf.format(Date(date))
            }
        }
    }

}