package com.sevenpeakssoftware.mehdi.domain.util

interface Mapper<T, Model> {

    suspend fun fromModel(model: Model): T

    suspend fun toModel(t: T): Model

    suspend fun fromModelList(list: List<Model>): List<T>

    suspend fun toModelList(list: List<T>): List<Model>
}