package scalaCookbook.c7packagingAndImports

object Imports extends App {

  //You want to rename members when you import them to help avoid namespace collisions or confusion.
  //  Give the class you’re importing a new name when you import it with this syntax:

  import java.util.{ArrayList => JavaList}


  //You want to hide one or more classes while importing other members from the same package.

  //To hide a class during the import process, use the renaming syntax shown in Recipe 7.3,
  // but point the class name to the _ wildcard character.

  import java.util.{Random => _, _}

//  You want to import members in a way similar to the Java static import approach, so you can refer
  //  to the member names directly, without having to prefix them with their class name.

//  Use this syntax to import all members of the Java Math class:

  import java.lang.Math._
}



