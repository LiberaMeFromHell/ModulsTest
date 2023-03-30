package com.codelabs.core_login_api.repository

import com.codelabs.core_login_api.model.CredentialsModel

interface LoginRepository {

    fun getCredentials(): CredentialsModel

    fun setCredentials(credential: CredentialsModel)
}
