package com.github.jesushzc.tvapp.domain.use_case

import android.text.format.DateFormat
import com.github.jesushzc.tvapp.utils.TypeDateFormat

class DateFormatterUseCase {

    operator fun invoke(type: TypeDateFormat): String {
        return when (type) {
            TypeDateFormat.DATE_ISO -> {
                val date = System.currentTimeMillis()
                DateFormat.format("yyyy-MM-dd", date).toString()
            }
            TypeDateFormat.DATE_FULL_STRING -> ""
        }
    }

}