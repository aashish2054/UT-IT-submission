package com.knoldus.validator

import java.util.regex.{Matcher, Pattern}

class EmailValidator {

  def emailIdIsValid(emailId: String): Boolean = {

    val emailRegex: String ="^[_A-Za-z0-9]+@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    val pattern: Pattern =Pattern.compile(emailRegex)

    //the method given below will return true if given email address is valid, else it will return false.
    val matcher:Matcher= pattern.matcher(emailId)
    matcher.matches

  }
}