package org.walethea.embedika_test_task.repository

import org.springframework.data.jpa.domain.Specification
import org.walethea.embedika_test_task.entity.CarEntity
import org.walethea.embedika_test_task.entity.enums.CarBrandsEnum
import java.time.Year
import java.util.*
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Root

object CarsSpecification {
    fun hasColor(color: String): Specification<CarEntity?> {
        return Specification { transaction: Root<CarEntity?>, _, cb: CriteriaBuilder ->
            cb.equal(
                transaction.get<Any>("color"),
                color
            )
        }
    }

    fun hasBrand(brand: CarBrandsEnum): Specification<CarEntity?> {
        return Specification { transaction: Root<CarEntity?>, _, cb: CriteriaBuilder ->
            cb.equal(
                transaction.get<Any>("brand"),
                brand
            )
        }
    }

    fun hasLicensePlate(licensePlate: String): Specification<CarEntity?> {
        return Specification { transaction: Root<CarEntity?>, _, cb: CriteriaBuilder ->
            cb.equal(
                transaction.get<Any>("licensePlate"),
                licensePlate
            )
        }
    }

    fun hasId(id: Long): Specification<CarEntity?> {
        return Specification { transaction: Root<CarEntity?>, _, cb: CriteriaBuilder ->
            cb.equal(
                transaction.get<Any>("id"),
                id
            )
        }
    }


    fun hasDateOfBirth(dateOfBirth: Year?): Specification<CarEntity?> {
        return Specification { transaction: Root<CarEntity?>, _, cb: CriteriaBuilder ->
            cb.equal(
                transaction.get<Any>("dateOfBirth"),
                dateOfBirth
            )
        }
    }
}