package com.jubayer_ahamad_tayef.lazy_column_practice_in_jetpack_compose.repository

import com.jubayer_ahamad_tayef.lazy_column_practice_in_jetpack_compose.model.Person
import kotlin.random.Random

class PersonRepository {
    fun generatePersons(): List<Person> {
        val firstNames = listOf(
            "John",
            "Jane",
            "Alice",
            "Bob",
            "Chris",
            "Emily",
            "Michael",
            "Sarah",
            "David",
            "Laura"
        )
        val lastNames = listOf(
            "Smith",
            "Johnson",
            "Brown",
            "Taylor",
            "Anderson",
            "Thomas",
            "Jackson",
            "White",
            "Harris",
            "Martin"
        )
        val baseUrl = "https://randomuser.me/api/portraits"

        return List(100) { index ->
            Person(
                id = index + 1,
                firstName = firstNames.random(),
                lastName = lastNames.random(),
                age = Random.nextInt(18, 60),
                imageUrl = "$baseUrl/men/${index % 100}.jpg"
            )
        }
    }
}