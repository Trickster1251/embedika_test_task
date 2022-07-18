package org.walethea.embedika_test_task.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import org.walethea.embedika_test_task.entity.CarEntity
import org.walethea.embedika_test_task.entity.enums.CarBrandsEnum
import org.walethea.embedika_test_task.responces.JSONResponse
import org.walethea.embedika_test_task.service.CarService
import java.time.Year

@RestController
@RequestMapping("/cars" ,produces = [MediaType.APPLICATION_JSON_VALUE])
class CarController(
    @Autowired val service : CarService
){

    @GetMapping("/","/{id}")
    fun getCars(@PathVariable(required = false) id: Long?,
                @RequestParam color : String?,
                @RequestParam brand : CarBrandsEnum?,
                @RequestParam licensePlate : String?,
                @RequestParam dateOfBirth: Year?
                ) : List<CarEntity>{
        return service.getAll(id, color, licensePlate, brand, dateOfBirth)
    }

//    @GetMapping("/{id}")
//    fun getById(@PathVariable id: Long): List<CarEntity>{
//        return service.getById(id)
//    }

    @PostMapping()
    fun addCar(car: CarEntity): JSONResponse {
        return service.add(car)
    }

    @DeleteMapping("/{id}")
    fun removeCar(@PathVariable id : Long): JSONResponse{
        return service.remove(id)
    }
}