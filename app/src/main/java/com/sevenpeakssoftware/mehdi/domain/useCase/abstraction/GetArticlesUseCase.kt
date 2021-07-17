package com.sevenpeakssoftware.mehdi.domain.useCase.abstraction

import com.sevenpeakssoftware.mehdi.domain.model.Article
import com.sevenpeakssoftware.mehdi.domain.util.Result

interface GetArticlesUseCase {
    operator fun invoke(): Result<List<Article>>
}