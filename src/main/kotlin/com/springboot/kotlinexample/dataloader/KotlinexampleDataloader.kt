package com.springboot.kotlinexample.dataloader

import com.springboot.kotlinexample.entity.User
import com.springboot.kotlinexample.dao.UserRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DataLoader {

    @Bean
    fun initDatabase(userRepository: UserRepository) = CommandLineRunner {
        userRepository.save(User(name="pupba1", email = "pupbani11@example.com"))
        userRepository.save(User(name="pupba2", email = "pupbani12@example.com"))
        userRepository.save(User(name="pupba3", email = "pupbani13@example.com"))
    }
}
