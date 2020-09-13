package com.codefun

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class User(
    @JsonProperty(value = "username") val username: String,
    @JsonProperty(value = "password") val password: String // TODO [Szymczuch] improve security in that area. Remove plain text
)