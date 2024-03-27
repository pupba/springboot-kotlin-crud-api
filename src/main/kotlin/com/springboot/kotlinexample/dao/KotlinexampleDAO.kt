package com.springboot.kotlinexample.dao

import com.springboot.kotlinexample.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>
