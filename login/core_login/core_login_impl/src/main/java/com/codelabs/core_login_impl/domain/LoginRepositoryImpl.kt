package com.codelabs.core_login_impl.domain

import com.codelabs.core_login_api.model.CredentialsModel
import com.codelabs.core_login_api.repository.LoginRepository
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(): LoginRepository {
    override fun getCredentials(): CredentialsModel {
        TODO("Not yet implemented")
    }

    override fun setCredentials(credential: CredentialsModel) {
        TODO("Not yet implemented")
    }
}