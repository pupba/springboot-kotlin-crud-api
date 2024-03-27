package com.springboot.kotlinexample.entity

// spring boot 3에서는 Jakarta EE 9가 포함됨에 따라 javax 관련 패키지명이 jakarta로 변경
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.persistence.Column


@Entity
@Table(name="`user`")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @Column(nullable = false)
    var name: String="",
    @Column(nullable = false)
    var email: String=""
)