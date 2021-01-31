package com.knoldus.validator

import com.knoldus.db.CompanyReadDto
import com.knoldus.models.Company

class CompanyValidator {

  def companyIsValid(company: Company): Boolean = {

    val companyDatabaseObj = new CompanyReadDto()
    val companyDbOutput: Option[Company] = companyDatabaseObj.getCompanyByName(company.name)

    val emailValidatorObj = new EmailValidator()
    val emailValidatorOutput = emailValidatorObj.emailIdIsValid(company.emailId)

    if (companyDbOutput.isEmpty && emailValidatorOutput)
      return true

    false
  }
}