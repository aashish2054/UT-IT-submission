package com.knoldus.request


import com.knoldus.models.User
import com.knoldus.validator.UserValidator
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.flatspec.AnyFlatSpec

class UserImplTest extends AnyFlatSpec {

  behavior of "UserImplTest"

  it should "create user" in {
    val testUser: User = User("Prashant","Trivedi",
      "prashant.trivedi@knoldus.com",
      "Knoldus")

    val mockedUserValidator = mock[UserValidator]
    when(mockedUserValidator.userIsValid(testUser)) thenReturn true

    val userImplTest = new UserImpl(mockedUserValidator)

    val result = userImplTest.createUser(testUser)

    assert(result == Option(testUser.firstname))
  }

  it should "not create user" in {
    val testUser: User = User("ronu","singh",
      "rfgtu$176@oppo.com",
      "oddo")

    val mockedUserValidator = mock[UserValidator]
    when(mockedUserValidator.userIsValid(testUser)) thenReturn false

    val userImplTest = new UserImpl(mockedUserValidator)

    val result = userImplTest.createUser(testUser)

    assert(result.isEmpty)
  }}