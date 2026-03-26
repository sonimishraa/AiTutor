package com.sonimishra.aitutor.utils

sealed interface UIState<out T>{
    data class Success<T>(val data:T):UIState<T>
    data class Error<T>(val message:String): UIState<T>
    object Loading: UIState<Nothing>
}