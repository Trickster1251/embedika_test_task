package org.walethea.embedika_test_task.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import org.walethea.embedika_test_task.entity.CarEntity
import org.walethea.embedika_test_task.entity.enums.CarBrandsEnum
import org.walethea.embedika_test_task.responces.DBStatsJSONResponse
import org.walethea.embedika_test_task.responces.JSONResponse
import org.walethea.embedika_test_task.service.CarService
import java.time.Year
import java.util.*

@RestController
@RequestMapping("/cars" ,produces = [MediaType.APPLICATION_JSON_VALUE])
class CarController(
    @Autowired val service : CarService
){

    @GetMapping("/","/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    fun getCars(@PathVariable(required = false) id: Long?,
                @RequestParam color : String?,
                @RequestParam brand : CarBrandsEnum?,
                @RequestParam licensePlate : String?,
                @RequestParam dateOfBirth: Year?
                ) : List<CarEntity>{
        return service.getAll(id, color, licensePlate, brand, dateOfBirth)
    }

    @GetMapping("/stats")
    @ResponseStatus(code = HttpStatus.OK)
    fun getStatsDBData() : DBStatsJSONResponse {
        return service.getStatsDB()
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    fun addCar(@RequestBody car: CarEntity): JSONResponse {
        return service.add(car)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    fun removeCar(@PathVariable id : Long): JSONResponse{
        return service.remove(id)
    }
}