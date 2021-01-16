package scalaCookbook.c4ClassesAndProperties

object SettingUninitializedVarFieldTypes extends App {

  //  You want to set the type for an uninitialized var field in a class,


  //In general, define the field as an Option. For certain types, such as String and numeric fields,
  // you can specify default initial values.


  case class Person(var username: String, var password: String) {

    var age = 0
    var firstName = ""
    var lastName = ""
    var address: Option[Address] = None: Option[Address]

  }

  case class Address(city: String, state: String, zip: String)

  val person = Person("alex", "secret")
  person.address = Some(Address("asd", "ad", "dd"))
  person.address.foreach { a =>
    println(a.city)
    println(a.state)
    println(a.zip)
  }

}
