package com.springboot.kotlinexample.controller

import org.springframework.web.bind.annotation.GetMapping
// JSP 인식을 못하고 그냥 문자열 index 반환
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PathVariable

// jsp
import org.springframework.ui.Model
import org.springframework.stereotype.Controller

// dto
import com.springboot.kotlinexample.dto.UserDto
// service
import com.springboot.kotlinexample.service.UserService

//@RestController
@Controller
@RequestMapping("/users")
class UserController(private val userService: UserService) {
    @GetMapping
    fun getAllUsers(model:Model):String{
        model.addAttribute("users",userService.findAllUsers())
        return "index"
    }

    @PostMapping
    fun addUser(@RequestBody userDto: UserDto): UserDto = userService.addUser(userDto)

    @PutMapping("/{id}")
    fun updateUser(@PathVariable id: Long, @RequestBody userDto: UserDto): UserDto = userService.updateUser(id, userDto)

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long) = userService.deleteUser(id)
}