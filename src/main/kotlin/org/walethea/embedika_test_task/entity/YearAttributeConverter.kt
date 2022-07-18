package org.walethea.embedika_test_task.entity

import java.time.Year
import javax.persistence.AttributeConverter
import javax.persistence.Converter

@Converter(autoApply = true)
class YearAttributeConverter : AttributeConverter<Year, Short> {

    override fun convertToDatabaseColumn(attribute : Year?) : Short? {
        if (attribute != null) {
            return attribute.value.toShort()
        }
        return null;
    }

    override fun convertToEntityAttribute(dbData : Short?) : Year? {
        if (dbData != null) {
            return Year.of(dbData.toInt());
        }
        return null;
    }
}