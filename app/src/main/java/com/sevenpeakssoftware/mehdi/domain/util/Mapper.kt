package com.sevenpeakssoftware.mehdi.domain.util

interface Mapper<T, Model> {

    fun fromModel(model: Model) : T

    fun toModel(t: T) : Model
}