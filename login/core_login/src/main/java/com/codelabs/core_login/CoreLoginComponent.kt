package com.codelabs.core_login

import com.codelabs.core_login_api.repository.LoginRepository
import com.codelabs.core_login_impl.domain.LoginRepositoryImpl
import dagger.Binds
import dagger.Component
import dagger.Module

@Module
interface LoginModule {
    @Binds
    fun bindLoginRepository(impl: LoginRepositoryImpl) : LoginRepository
}

@Component(
    modules = [LoginModule::class]
)
interface CoreLoginComponent {

    @Component.Builder
    interface Builder {
        fun build(): CoreLoginComponent
    }

    companion object {

        fun create(): CoreLoginComponent =
            DaggerCoreLoginComponent
                .builder()
                .build()
    }

    fun provideLoginRepository() : LoginRepository
}
