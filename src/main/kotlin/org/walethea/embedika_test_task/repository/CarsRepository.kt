package org.walethea.embedika_test_task.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.walethea.embedika_test_task.entity.CarEntity

interface CarsRepository : JpaRepository<CarEntity, Long>, JpaSpecificationExecutor<CarEntity>{

}