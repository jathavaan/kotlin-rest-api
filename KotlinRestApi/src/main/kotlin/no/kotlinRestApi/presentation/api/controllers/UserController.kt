package no.kotlinRestApi.presentation.api.controllers

import no.kotlinRestApi.core.application.features.account.query.getUserByIdQuery.GetUserByIdQuery

import no.kotlinRestApi.core.application.features.account.query.getUserByIdQuery.GetUserByIdQueryHandler
import no.kotlinRestApi.core.application.viewModels.UserVm
import no.kotlinRestApi.core.application.common.Response
import no.kotlinRestApi.core.application.features.account.query.getAllUsersQuery.GetAllUsersQuery
import no.kotlinRestApi.core.application.features.account.query.getAllUsersQuery.GetAllUsersQueryHandler
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(
    val getUserByIdQueryHandler: GetUserByIdQueryHandler,
    val getAllUsersQueryHandler: GetAllUsersQueryHandler
) {
    @GetMapping("get")
    fun getAllUsers(): ResponseEntity<Response<List<UserVm>>> = getAllUsersQueryHandler.handle(GetAllUsersQuery())

    @GetMapping("get/{userId}")
    fun getUserById(@PathVariable userId: Int): ResponseEntity<Response<UserVm>> =
        getUserByIdQueryHandler.handle(GetUserByIdQuery(userId))
}