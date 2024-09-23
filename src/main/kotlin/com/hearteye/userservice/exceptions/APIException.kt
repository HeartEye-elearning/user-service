package com.hearteye.userservice.exceptions

import com.hearteye.userservice.enums.ErrorCode
import java.lang.Exception

class APIException(override val message: String, val errorCode: ErrorCode) : Exception(message)