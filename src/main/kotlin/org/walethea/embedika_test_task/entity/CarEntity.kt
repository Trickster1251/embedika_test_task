package org.walethea.embedika_test_task.entity

import org.walethea.embedika_test_task.entity.enums.CarBrandsEnum
import java.time.Year
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "cars")
class CarEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,

    var licensePlate : String,

    @Enumerated(EnumType.STRING)
    var brand : CarBrandsEnum,

    var color : String?,

//    @Convert(converter = YearAttributeConverter::class)
    var dateOfBirth : Year?,

    @Temporal(TemporalType.TIMESTAMP)
    var createdAt : Date?
) {
}