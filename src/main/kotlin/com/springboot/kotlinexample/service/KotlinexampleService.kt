package com.springboot.kotlinexample.service

import com.springboot.kotlinexample.dto.UserDto
import com.springboot.kotlinexample.dao.UserRepository
import com.springboot.kotlinexample.entity.User
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

interface UserService {
    fun findAllUsers(): List<UserDto>
    fun addUser(userDto: UserDto): UserDto
    fun updateUser(id: Long, userDto: UserDto): UserDto
    fun deleteUser(id: Long)
}

@Service
class UserServiceImpl(private val userRepository: UserRepository) : UserService {
    @Transactional(readOnly = true)
    override fun findAllUsers(): List<UserDto> = userRepository.findAll().map { UserDto(it.name, it.email) }

    @Transactional
    override fun addUser(userDto: UserDto): UserDto {
        val user = userRepository.save(User(name = userDto.name, email = userDto.email))
        return UserDto(user.name, user.email)
    }

    @Transactional
    override fun updateUser(id: Long, userDto: UserDto): UserDto {
        val user = userRepository.findById(id).orElseThrow { RuntimeException("User not found") }
        user.name = userDto.name
        user.email = userDto.email
        val updatedUser = userRepository.save(user)
        return UserDto(updatedUser.name, updatedUser.email)
    }

    @Transactional
    override fun deleteUser(id: Long) {
        userRepository.deleteById(id)
    }
}
