package com.knoldus.validator

import com.knoldus.models.Company
import org.scalatest.flatspec.AnyFlatSpec

class CompanyValidatorTest extends AnyFlatSpec {

  val companyValidator = new CompanyValidator()

  "Company" should "be valid" in {
    val companyTesting: Company = Company("hayabusa",
      "wwer@haya.com",
      "Gurgaon")

    val testResult = companyValidator.companyIsValid(companyTesting)

    assert(testResult)

  }
  "Company" should "not be valid" in {
    val companyTesting: Company = Company("hayabusa",
      "wef@honda...com",
      "Gurgaon")

    val testResult = companyValidator.companyIsValid(companyTesting)

    assert(!testResult)

  }
  "Company" should "not be valid as it already exist in DB" in {
    val companyTesting: Company = Company("Knoldus",
      "you@honda.com",
      "Gurgaon")

    val testResult = companyValidator.companyIsValid(companyTesting)

    assert(!testResult)

  }



}