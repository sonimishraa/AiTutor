package com.sonimishra.aitutor.model

data class QueryRequest(
	val goal: String? = null,
	val user_query: String? = null,
	val level: String? = null,
	val subject: String? = null,
	val topic: String? = null
)

