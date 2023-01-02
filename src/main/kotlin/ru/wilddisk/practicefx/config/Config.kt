package ru.wilddisk.practicefx.config

interface Config<T> {
    fun build(): T
}