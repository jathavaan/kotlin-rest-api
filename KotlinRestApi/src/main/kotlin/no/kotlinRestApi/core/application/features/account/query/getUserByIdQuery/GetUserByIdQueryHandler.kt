package no.kotlinRestApi.core.application.features.account.query.getUserByIdQuery

import no.kotlinRestApi.core.application.viewModels.UserVm
import no.kotlinRestApi.core.application.common.Response
import no.kotlinRestApi.core.application.common.SendResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component

@Component
class GetUserByIdQueryHandler {
    fun handle(query: GetUserByIdQuery): ResponseEntity<Response<UserVm>> {
        if (query.userId != 1){
            return SendResponse.error("Could not find user with id ${query.userId}", HttpStatus.NOT_FOUND)
        }

        val userVm = UserVm(1, "jathavaan.shankarr@bekk.no", "Jathavaan Shankarr")
        return SendResponse.success(userVm, HttpStatus.OK)
    }
}