package com.miapp.data.repositories

import com.miapp.data.datasources.LocalPersonDataSource
import com.miapp.data.datasources.RemotePersonDataSource

class PersonRepository(
    private val localPersonDataSource: LocalPersonDataSource,
    private val remotePersonDataSource: RemotePersonDataSource
    ) {
}