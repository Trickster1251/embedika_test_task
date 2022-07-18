package org.walethea.embedika_test_task

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.orm.hibernate5.LocalSessionFactoryBean




@SpringBootApplication()
class EmbedikaTestTaskApplication

fun main(args: Array<String>) {
    runApplication<EmbedikaTestTaskApplication>(*args)
}