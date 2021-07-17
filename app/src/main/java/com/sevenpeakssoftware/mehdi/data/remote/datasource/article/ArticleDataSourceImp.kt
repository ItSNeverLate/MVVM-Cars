//package com.sevenpeakssoftware.mehdi.data.remote.datasource.article
//
//import com.sevenpeakssoftware.mehdi.data.remote.AppService
//import com.sevenpeakssoftware.mehdi.data.remote.datasource.BaseDataSource
//import com.sevenpeakssoftware.mehdi.data.remote.mapper.ArticleDtoMapper
//import com.sevenpeakssoftware.mehdi.domain.model.Article
//import com.sevenpeakssoftware.mehdi.domain.util.Result
//
//class ArticleDataSourceImp(
//    private val service: AppService,
//) : BaseDataSource(), ArticleDataSource {
//
//
//    override suspend fun getArticles(): Result<List<Article>> =
////        getResult { service.getArticles() }
//
//        when (val apiResult = getResult { service.getArticles() }) {
//            is Result.Success -> Result.Success(apiResult.data.map { ArticleDtoMapper.toModel(it) })
//            is Result.Error -> Result.Error(apiResult.message)
//        }
//
//}