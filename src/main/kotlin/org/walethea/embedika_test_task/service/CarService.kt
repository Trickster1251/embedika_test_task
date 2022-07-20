package org.walethea.embedika_test_task.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Sort
import org.springframework.data.jpa.domain.Specification
import org.springframework.data.jpa.domain.Specification.where
import org.springframework.stereotype.Service
import org.walethea.embedika_test_task.entity.CarEntity
import org.walethea.embedika_test_task.entity.enums.CarBrandsEnum
import org.walethea.embedika_test_task.exceptions.NotValidBrandNameException
import org.walethea.embedika_test_task.exceptions.ObjectAlreadyExistsException
import org.walethea.embedika_test_task.exceptions.ObjectNotFoundException
import org.walethea.embedika_test_task.repository.CarsRepository
import org.walethea.embedika_test_task.repository.CarsSpecification
import org.walethea.embedika_test_task.responces.DBStatsJSONResponse
import org.walethea.embedika_test_task.responces.JSONResponse
import java.time.Year
import java.util.*

@Service
class CarService(
    @Autowired private val repository : CarsRepository,
) {

    fun getAll(
        id: Long? = null,
        color: String?,
        licensePlate :String?,
        brand: CarBrandsEnum?,
               dateOfBirth : Year?
    ): List<CarEntity> {

        var txFilter: Specification<CarEntity> = where(null);

        if (id != null)
            txFilter = txFilter.and(CarsSpecification.hasId(id))
        if (color != null)
            txFilter = txFilter.and(CarsSpecification.hasColor(color))
        if (brand != null)
            txFilter = txFilter.and(CarsSpecification.hasBrand(brand))
        if (licensePlate != null)
            txFilter = txFilter.and(CarsSpecification.hasLicensePlate(licensePlate))
        if (dateOfBirth != null)
            txFilter = txFilter.and(CarsSpecification.hasDateOfBirth(dateOfBirth))
        return repository.findAll(txFilter)
    }

    fun add(entity : CarEntity): JSONResponse {
        return try {
            if (repository.findByLicensePlate(entity.licensePlate) != null)
                throw ObjectAlreadyExistsException()
            if (!CarBrandsEnum.values().contains(entity.brand))
                throw NotValidBrandNameException()
            entity.createdAt = Date()
            repository.save(entity)
            JSONResponse(201, "Successfully created")
        } catch (e: Exception) {

            var http_code = 500
            if (e is ObjectNotFoundException || e is NotValidBrandNameException) {
                http_code = 409
            }

            JSONResponse(http_code, e.message!!)
        }
    }

    fun remove(id :Long): JSONResponse {
        return try {
            repository.deleteById(id)
            JSONResponse(200, "Successfully deleted!")
        } catch (e: Exception) {
            JSONResponse(404, ObjectNotFoundException().message!!)
        }
    }

    fun getStatsDB(): DBStatsJSONResponse {
        val dbInfo = repository.findAll(Sort.by("createdAt"))
        return DBStatsJSONResponse(200,
            first_record_be_created = dbInfo.first().createdAt,
            last_record_be_created = dbInfo.last().createdAt,
            record_count = dbInfo.count())
    }
}
