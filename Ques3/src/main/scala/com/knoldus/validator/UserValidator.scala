package com.knoldus.validator

import com.knoldus.db.CompanyReadDto
import com.knoldus.models.{Company, User}

class UserValidator {


  def userIsValid(user: User): Boolean = {

    val companyDatabaseObj = new CompanyReadDto()
    val companyDbOutput: Option[Company] = companyDatabaseObj.getCompanyByName(user.company)

    val emailValidatorObj = new EmailValidator()
    val emailValidatorOutput = emailValidatorObj.emailIdIsValid(user.email)

    if (companyDbOutput.isDefined && emailValidatorOutput) return true

    false
  }

}