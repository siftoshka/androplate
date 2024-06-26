package com.androplate.data.repository

import com.androplate.data.remote.api.TemplateApi
import com.androplate.domain.repository.TemplateRepository
import javax.inject.Inject

class TemplateRepositoryImpl @Inject constructor(
    private val api: TemplateApi,
) : TemplateRepository {

}