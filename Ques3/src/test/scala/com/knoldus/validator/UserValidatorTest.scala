package com.knoldus.validator


import com.knoldus.models.User
import org.scalatest.flatspec.AnyFlatSpec

class UserValidatorTest extends AnyFlatSpec {

  val userValidator:UserValidator=new UserValidator()

  behavior of  "this user"

  it should "be valid as its company exist in database and the email id is also written in correct format" in{
    val user:User= User("Ashish","chaudhary","ashish@gmail.com","Philips")
    assert(userValidator.userIsValid(user))
  }

  it should "not be valid as its company does not exist in database and the email id is also invalid" in{
    val user:User= User("sumit","Sriva","amit@gm@ail.com","roman Tech")
    assert(!userValidator.userIsValid(user))
  }

  it should "not be valid as its email id is invalid" in{
    val user:User= User("sukla","singh","sukla@gmail..com","Knoldus")
    assert(!userValidator.userIsValid(user))
  }

  it should "not be valid as its company does not exist in database" in{
    val user:User= User("aman","sharma","aman345@gmail.com","Microsoft")
    assert(!userValidator.userIsValid(user))
  }

}