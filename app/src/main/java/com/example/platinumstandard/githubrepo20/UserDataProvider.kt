package com.example.platinumstandard.githubrepo20

import com.example.platinumstandard.githubrepo20.Models.SearchModels.SearchUserModel
import com.example.platinumstandard.githubrepo20.Models.HomeModels.SearchUserResultModel
import com.example.platinumstandard.githubrepo20.Models.RepoListModel.RepoResult
import com.example.platinumstandard.githubrepo20.Models.Urls
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.github.kittinunf.fuel.httpGet
import com.google.gson.Gson
import java.io.Reader
import java.lang.Exception

class UserDataProvider {

    fun search(login: String, responseHandler: (result: SearchUserModel) -> Unit?) {
        Urls.getSearchUserUrl(login).httpGet()
                .responseObject((GitHubDataDeserializer2())) { _, response, result ->

                    if (response.httpStatusCode != 200) {
                        throw Exception("Could not find user")

                    }
                    val (data, _) = result
                    responseHandler.invoke(data as SearchUserModel)
                }
    }

    fun getRandom(page: Int, responseHandler: (result: SearchUserResultModel) -> Unit?) {
        Urls.getReposUrl(page).httpGet()
                .responseObject(GitHubDataDeserializer()) { _, response, result ->

                    if (response.httpStatusCode != 200) {
                        throw Exception("Unable to find user")
                    }
                    val (data, _) = result
                    responseHandler.invoke(data!! as  @kotlin.ParameterName SearchUserResultModel)

                }

    }

    fun getSearchedRepo(login: String, page: Int, responseHandler: (result: RepoResult) -> Unit?) {
        Urls.getSearchedReposUrl(login, page).httpGet()
                .responseObject(GitHubDataDeserializer3()) { _, response, result ->

                    if (response.httpStatusCode != 200) {
                        throw Exception("Unable to find user")
                    }
                    val (data, _) = result
                    responseHandler.invoke(data!! as @kotlin.ParameterName(name = "result") RepoResult)

                }
    }

    class GitHubDataDeserializer : ResponseDeserializable<SearchUserResultModel> {
        override fun deserialize(reader: Reader) = Gson().fromJson(reader, SearchUserResultModel::class.java)

    }

    class GitHubDataDeserializer2 : ResponseDeserializable<SearchUserModel> {
        override fun deserialize(reader: Reader) = Gson().fromJson(reader, SearchUserModel::class.java)

    }

    class GitHubDataDeserializer3 : ResponseDeserializable<RepoResult> {
        override fun deserialize(reader: Reader) = Gson().fromJson(reader, RepoResult::class.java)

    }
}

