package no.kotlinRestApi.core.application.features.account.query.getAllUsersQuery

import no.kotlinRestApi.core.application.viewModels.UserVm
import no.kotlinRestApi.core.application.common.Response
import no.kotlinRestApi.core.application.common.SendResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component

@Component
class GetAllUsersQueryHandler {
    fun handle(getAllUsersQuery: GetAllUsersQuery): ResponseEntity<Response<List<UserVm>>> {
        val userVms = listOf(
            UserVm(1, "jathavaan.shankarr@bekk.no", "Jatha1"),
            UserVm(2, "jathavaan.s@gmail.com", "Jatha2"),
            UserVm(3, "jathavas@ntnu.no", "Jatha3")
        )

        return SendResponse.success(userVms, HttpStatus.OK)
    }
}