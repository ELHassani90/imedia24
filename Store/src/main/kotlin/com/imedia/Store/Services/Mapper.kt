package com.imedia.Store.Services

interface Mapper<D, E> {
    fun fromEntity(entity: E):D
    fun toEntity(domain: D):E
}